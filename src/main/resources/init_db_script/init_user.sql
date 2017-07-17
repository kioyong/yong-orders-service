db.user.insert([
{
    "_id" : "1000",
    "_class" : "com.yong.orders.model.User",
    "name" : "LiangYong",
    "departmentGroupList" : [ 
        {
            "_id" : "1001",
            "name" : "mce",
            "type" : "developer"
        }
    ],
    "age" : 18
}

,
{
    "_id" : "1002",
    "_class" : "com.yong.orders.model.User",
    "name" : "test2",
    "age" : 20,
    "departmentGroupList" : [ 
        {
            "_id" : "1002",
            "name" : "cpa",
            "type" : "developer"
        }, 
        {
            "_id" : "1003",
            "name" : "pca",
            "type" : "developer"
        }, 
        {
            "_id" : "1004",
            "name" : "rcs",
            "type" : "developer"
        }
    ]
}

,
{
    "_id" : "1003",
    "_class" : "com.yong.orders.model.User",
    "name" : "test3",
    "age" : 22,
    "departmentGroupList" : [ 
        {
            "_id" : "1001",
            "name" : "mce",
            "type" : "developer"
        }, 
        {
            "_id" : "1002",
            "name" : "cpa",
            "type" : "developer"
        }, 
        {
            "_id" : "1003",
            "name" : "pca",
            "type" : "developer"
        }, 
        {
            "_id" : "1004",
            "name" : "rcs",
            "type" : "developer"
        }
    ],
    "address" : {
        "add" : "TianHeBei",
        "location" : "ShangHai",
        "country" : "China"
    }
}

,
{
    "_id" : "1004",
    "_class" : "com.yong.orders.model.User",
    "name" : "test4",
    "age" : 22,
    "address" : {
        "add" : "TianHeBei",
        "location" : "ShangHai",
        "country" : "China"
    },
    "departmentGroupList" : [ 
        {
            "_id" : "1003",
            "name" : "pca",
            "type" : "developer"
        }, 
        {
            "_id" : "1004",
            "name" : "rcs",
            "type" : "developer"
        }, 
        {
            "_id" : "1005",
            "name" : "pcs",
            "type" : "developer"
        }
    ],
    "version" : NumberLong(0)
}

,
{
    "_id" : "1005",
    "_class" : "com.yong.orders.model.User",
    "name" : "test5",
    "age" : 22,
    "address" : {
        "add" : "TianHeBei",
        "location" : "ShangHai",
        "country" : "China"
    },
    "departmentGroupList" : [ 
        {
            "_id" : "1001",
            "name" : "mce",
            "type" : "developer"
        }, 
        {
            "_id" : "1002",
            "name" : "cpa",
            "type" : "developer"
        }, 
        {
            "_id" : "1003",
            "name" : "pca",
            "type" : "developer"
        }
    ],
    "version" : NumberLong(0)
}

,
{
    "_id" : "1006",
    "_class" : "com.yong.orders.model.User",
    "name" : "test5",
    "age" : 22,
    "address" : {
        "add" : "TianHeBei",
        "location" : "ShangHai",
        "country" : "China"
    },
    "departmentGroupList" : [ 
        {
            "_id" : "1001",
            "name" : "mce",
            "type" : "developer"
        }, 
        {
            "_id" : "1005",
            "name" : "pcs",
            "type" : "developer"
        }
    ],
    "version" : NumberLong(0)
}

,
{
    "_id" : "1001",
    "_class" : "com.yong.orders.model.User",
    "name" : "test department group",
    "age" : 20,
    "departmentGroupList" : [ 
        {
            "_id" : "1001",
            "name" : "mce",
            "type" : "developer"
        }, 
        {
            "_id" : "1002",
            "name" : "cpa",
            "type" : "developer"
        }, 
        {
            "_id" : "1003",
            "name" : "pca",
            "type" : "developer"
        }, 
        {
            "_id" : "1004",
            "name" : "rcs",
            "type" : "developer"
        }, 
        {
            "_id" : "1005",
            "name" : "pcs",
            "type" : "developer"
        }
    ],
    "address" : {
        "add" : "TianHeBei",
        "location" : "ShangHai",
        "country" : "China"
    },
    "version" : NumberLong(0)
}])