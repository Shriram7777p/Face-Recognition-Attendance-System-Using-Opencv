import pandas as pd
import firebase_admin
from firebase_admin import credentials, db

# Initialize Firebase with your service account key
cred = credentials.Certificate("ai-eras-firebase-adminsdk.json")
firebase_admin.initialize_app(cred, {
    'databaseURL': 'https://ai-eras-default-rtdb.firebaseio.com'
})
# Specify column names explicitly
column_names = ['Name']  # Replace with actual column names
df = pd.read_csv('mark.csv', names=column_names)
temp=[]
nameList = []
nameList1 = []
timeList = []
seen = {}
unique_items = []
flag=0

def original(nameList):
    for item in nameList:
            if item not in seen:
                seen[item] = True
                unique_items.append(item)
    return unique_items
def switch_case(ch,name):
    for time_str in ch:
        unique_items=[]
        seen={}
        if '09:30 AM' < time_str < '09:40 AM':
            flag=1
            nameList1.append(name)
        return nameList1,flag
        if '10:20 AM' < time_str < '10:30 AM':
            flag=2
            nameList2.append(name)
        return nameList1,flag
        if '11:25 AM' < time_str < '11:35 AM':
            flag=3
            nameList3.append(name)
        return nameList1,flag
        if '12:15 PM' < time_str < '12:25 PM':
            flag=4
            nameList4.append(name)
        return nameList1,flag
        if '02:00 PM' < time_str < '02:10 PM':
            flag=5
            nameList5.append(name)
        return nameList1,flag
        if '02:50 PM' < time_str < '03:00 PM':
            flag=6
            nameList6.append(name)
        return nameList1,flag
        if '03:50 PM' < time_str < '04:00 PM':
            flag=7
            nameList7.append(name)
        return nameList7,flag

with open('attendance.csv', 'r+') as f:
    with open('mark.csv','r+') as m:
        myDataList = f.readlines()
        myDataList2 = m.readlines()
        for line in myDataList:
            entry = line.split(',')
            nameList.append(entry[0])
            timeList.append(entry[1:2])
        for i in range(len(nameList)):
            ch=timeList[i]
            name=nameList[i]
            temp_flag=switch_case(ch,name)
        if temp_flag is not None:
            temp, flag = temp_flag
        print("Temp:",temp)
        print("flag:",flag)
        if flag==1:
            for im in range(len(nameList1)):
                print(nameList1[im],"Updated succesfully")
                m.writelines(f'\n{nameList1[im]}')
        if flag==2:
            for im in range(len(nameList2)):
                print(nameList2[im],"Updated succesfully")
                m.writelines(f'\n{nameList2[im]}')
        if flag==3:
            for im in range(len(nameList3)):
                print(nameList3[im],"Updated succesfully")
                m.writelines(f'\n{nameList3[im]}')
        if flag==4:
            for im in range(len(nameList4)):
                print(nameList4[im],"Updated succesfully")
                m.writelines(f'\n{nameList4[im]}')
        if flag==5:
            for im in range(len(nameList5)):
                print(nameList5[im],"Updated succesfully")
                m.writelines(f'\n{nameList5[im]}')
        if flag==6:
            for im in range(len(nameList6)):
                print(nameList6[im],"Updated succesfully")
                m.writelines(f'\n{nameList6[im]}')
        if flag==7:
            for im in range(len(nameList7)):
                print(nameList7[im],"Updated succesfully")
                m.writelines(f'\n{nameList7[im]}')
        # Reference to your Firebase database
        ref = db.reference('class1')
        for index,row in df.iterrows():
            data_dict = row.to_dict()
            print("updated",data_dict)
            ref.child(str(index)).update(data_dict)
        ref = db.reference('class2')
        for index,row in df.iterrows():
            data_dict = row.to_dict()
            print("updated",data_dict)
            ref.child(str(index)).update(data_dict)
        ref = db.reference('class3')
        for index,row in df.iterrows():
            data_dict = row.to_dict()
            print("updated",data_dict)
            ref.child(str(index)).update(data_dict)
        ref = db.reference('class4')
        for index,row in df.iterrows():
            data_dict = row.to_dict()
            print("updated",data_dict)
            ref.child(str(index)).update(data_dict)
        ref = db.reference('class5')
        for index,row in df.iterrows():
            data_dict = row.to_dict()
            print("updated",data_dict)
            ref.child(str(index)).update(data_dict)
        ref = db.reference('class6')
        for index,row in df.iterrows():
            data_dict = row.to_dict()
            print("updated",data_dict)
            ref.child(str(index)).update(data_dict)
        ref = db.reference('class7')
        for index,row in df.iterrows():
            data_dict = row.to_dict()
            print("updated",data_dict)
            ref.child(str(index)).update(data_dict)


