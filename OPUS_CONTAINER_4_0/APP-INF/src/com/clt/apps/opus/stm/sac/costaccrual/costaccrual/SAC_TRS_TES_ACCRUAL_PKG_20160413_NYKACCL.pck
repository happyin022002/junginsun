CREATE OR REPLACE PACKAGE SAC_TRS_TES_ACCRUAL_PKG
    AUTHID CURRENT_USER
AS
    --pi_exeMonth : accrual Month
    --pi_user_id : OPUS User ID
    PROCEDURE TES_ACCRUAL_INSERT
    (
            pi_exeMonth     IN  VARCHAR2
        ,   pi_user_id      IN  VARCHAR2
        ,   po_result       OUT VARCHAR2
    );

    --pi_exeMonth : accrual Month
    --pi_user_id : OPUS User ID
    PROCEDURE TRS_ACCRUAL_INSERT
    (
            pi_exeMonth     IN  VARCHAR2
        ,   pi_user_id      IN  VARCHAR2
        ,   po_result       OUT VARCHAR2
    );
    
END SAC_TRS_TES_ACCRUAL_PKG;
/
CREATE OR REPLACE PACKAGE BODY SAC_TRS_TES_ACCRUAL_PKG
AS
    --pi_exeMonth : accrual Month
    --pi_user_id : OPUS User ID
    PROCEDURE TES_ACCRUAL_INSERT
    (
            pi_exeMonth     IN  VARCHAR2
        ,   pi_user_id      IN  VARCHAR2
        ,   po_result       OUT VARCHAR2
    )
    IS
        R_ACT_AMT           NUMBER          :=  NULL;
        R_ACT_QTY           NUMBER          :=  NULL;
        R_EXEC_CNT          NUMBER          :=  0;

        ERRMSG              VARCHAR2(4000)  :=  NULL;
        R_ACT_PLC_CD        VARCHAR2(5)     :=  NULL;

        R_ACT_DT            DATE            :=  NULL;
        
        my_exception        EXCEPTION;
    BEGIN
        SELECT  TO_NUMBER(NVL(MAX(ATTR_CTNT2), '0')) + 1
        INTO    R_EXEC_CNT
        FROM    SAC_IF_ERR_LOG
        WHERE   1 = 1
          AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'
          AND   SRC_MDL_CD  = 'ACCLTES'
          AND   ERR_DESC    = 'EXEC_LOG'
          AND   EXE_YRMON   = pi_exeMonth
          AND   ATTR_CTNT1  = TO_CHAR(SYSDATE, 'YYYYMMDD')
        ;

        --Package Execution Start Log Insert...
        SCO_ERR_LOG_PRC
        (
            	PI_PGM_APPL_NM 	=>	'SAC_TRS_TES_ACCRUAL_PKG'
            ,   PI_ERR_DESC   	=>	'EXEC_LOG'
            ,   PI_EXE_YRMON  	=>	pi_exeMonth
            ,   PI_MOD_NAME   	=>	'ACCLTES'
            ,   PI_ATTR_CTNT1 	=>	TO_CHAR(SYSDATE, 'YYYYMMDD')
            ,   PI_ATTR_CTNT2 	=>	R_EXEC_CNT
            ,   PI_ATTR_CTNT3 	=>	'START'
            ,	PI_ATTR_CTNT4 	=>	''	
            ,	PI_ATTR_CTNT5 	=>	''  	
        );
        
        -- Dup Data Delete...
        DELETE FROM SAC_TML_ACCL_COST_IF  WHERE EXE_YRMON = pi_exeMonth;
        DELETE FROM SAC_COST_ACCL_INFO    WHERE SYS_SRC_ID = 'TES' AND EXE_YRMON = pi_exeMonth;

        -- Accrual Month기준으로 Revenue Month가 previous 6개월까지는 cancelFlag으로 'N'으로 Accrua Data를 생성하고 6개월이전데이타는 cancel Flag를 'Y'로 생성한다.
        -- ex). accrual Month : 12월이면 revenue Month 6~12는 cancelFlag 'N', revenueMonth가 ~05월까지는 'Y'
        INSERT INTO SAC_TML_ACCL_COST_IF
        (
            	EXE_YRMON               --1
            ,	SYS_SRC_ID
            ,	REV_YRMON
            ,	ACCT_CD
            ,	ACCL_SEQ                --5
            ,	BIZ_UT_ID
            ,	VSL_CD
            ,	SKD_VOY_NO
            ,	SKD_DIR_CD
            ,	REV_DIR_CD              --10
            ,	ESTM_VVD_TP_CD
            ,	ESTM_IOC_DIV_CD
            ,	ESTM_BC_DIV_CD
            ,	NOD_CD
            ,	ESTM_COST_AMT           --15
            ,	ACCL_COST_AMT
            ,	BKG_NO
            ,	CNTR_TPSZ_CD
            ,	RLANE_CD
            ,	CNTR_QTY                --20
            ,	ESTM_QTY
            ,	ACCL_QTY
            ,	VNDR_NO
            ,	ESTM_UC_AMT
            ,	COA_COST_SRC_CD         --25
            ,   LOCL_CURR_CD
            ,   SLAN_CD
            ,   ACT_DT
            ,	CRE_USR_ID
            ,	CRE_DT                  --30
            ,	UPD_USR_ID              
            ,	UPD_DT                  
            ,   CXL_FLG                 
            ,   CTRL_OFC_CD             --34
        )
        SELECT  EXE_YRMON                                                                                   --1
            ,	'TES'      
            ,	REV_YRMON       
            ,	ACCT_CD         
            ,   ROW_NUMBER() OVER (ORDER BY AA.EXE_YRMON,AA.REV_YRMON,AA.ACCT_CD)       AS  ACCL_SEQ        --5
            ,	'CNTR'       
            ,	VSL_CD          
            ,	SKD_VOY_NO      
            ,	SKD_DIR_CD      
            ,	REV_DIR_CD                                                                                  --10   
            ,	ESTM_VVD_TP_CD  
            ,	ESTM_IOC_DIV_CD 
            ,	ESTM_BC_DIV_CD  
            ,	NOD_CD          
            ,	ROUND(ESTM_COST_AMT, SAC_BRG_IF_PKG.GET_AMT_PRECISION(LOCL_CURR_CD))    AS  ESTM_COST_AMT   --15
            ,	ROUND(ACCL_COST_AMT, SAC_BRG_IF_PKG.GET_AMT_PRECISION(LOCL_CURR_CD))    AS  ACCL_COST_AMT   
            ,	BKG_NO          
            ,	CNTR_TPSZ_CD    
            ,	RLANE_CD        
            ,	CNTR_QTY                                                                                    --20
            ,	ESTM_QTY        
            ,	ACCL_QTY        
            ,	VNDR_NO         
            ,	ESTM_UC_AMT     
            ,	COA_COST_SRC_CD                                                                             --25
            ,	LOCL_CURR_CD    
            ,	SLAN_CD         
            ,	ACT_DT          
            ,	NVL(pi_user_id, 'SYSTEM')                                               AS  CRE_USR_ID
            ,	SYSDATE                 										        AS  CRE_DT          --30 
            ,	NVL(pi_user_id, 'SYSTEM')                 							    AS  UPD_USR_ID              
            ,	SYSDATE                 										        AS  UPD_DT                 
            ,	CXL_FLG                                                                             
            ,   CTRL_OFC_CD                                                                                 --34
        FROM
        (
            SELECT  B.EXE_YRMON                                                     AS  EXE_YRMON               --1
                ,	A.REV_YRMON             										AS  REV_YRMON
                ,	A.ACCT_CD               										AS  ACCT_CD
                ,	A.VSL_CD                										AS  VSL_CD
                ,	A.SKD_VOY_NO            										AS  SKD_VOY_NO              --5
                ,   A.SKD_DIR_CD            										AS  SKD_DIR_CD
                ,	A.REV_DIR_CD            										AS  REV_DIR_CD              
                ,	B.ESTM_VVD_TP_CD        										AS  ESTM_VVD_TP_CD          
                ,	B.ESTM_IOC_DIV_CD       										AS  ESTM_IOC_DIV_CD
                ,	B.ESTM_BC_DIV_CD        										AS  ESTM_BC_DIV_CD          --10
                ,	A.N1ST_NOD_CD           										AS  NOD_CD
                ,	NVL(A.ESTM_COST_AMT, 0) 										AS  ESTM_COST_AMT           
                ,	NVL(A.ESTM_COST_AMT, 0) 										AS  ACCL_COST_AMT           
                ,	A.BKG_NO                										AS  BKG_NO
                ,	A.CNTR_TPSZ_CD          										AS  CNTR_TPSZ_CD            --15
                ,	A.RLANE_CD              										AS  RLANE_CD
                ,	NVL(A.CNTR_QTY, 0)      										AS  CNTR_QTY
                ,	NVL(A.CNTR_QTY, 0)      										AS  ESTM_QTY                
                ,	NVL(A.CNTR_QTY, 0)      										AS  ACCL_QTY
                ,	A.N1ST_VNDR_SEQ         										AS  VNDR_NO                 --20
                ,	NVL(A.ESTM_UC_AMT, 0)   										AS  ESTM_UC_AMT
                ,	A.COA_COST_SRC_CD       										AS  COA_COST_SRC_CD
                ,   A.LOCL_CURR_CD             										AS  LOCL_CURR_CD            
                ,   SUBSTR(A.RLANE_CD,1,3)                  						AS  SLAN_CD
                ,   A.ACT_DT                                                        AS  ACT_DT                  --25
                ,	'N'                 										    AS  CXL_FLG                 
                ,   A.CTRL_OFC_CD                                                   AS  CTRL_OFC_CD             --27
            FROM    (
                        SELECT  XX.*
                        FROM
                        (
                            SELECT  RANK() OVER(PARTITION BY X.BKG_NO ORDER BY X.BKG_UPD_DT DESC) LST_SEQ
                                ,   X.*
                            FROM    SAC_TML_ESTM_COST_IF X
                        ) XX
                        WHERE   XX.LST_SEQ = 1
                    )                           A
                ,   SAC_ESTM_REV_VVD            B
            WHERE   1 = 1
              AND   A.REV_YRMON IS NOT NULL
              AND   NVL(A.ESTM_COST_AMT, 0) > 0
              AND   B.EXE_YRMON     =   pi_exeMonth
              AND   B.VSL_CD        =   A.VSL_CD
              AND   B.SKD_VOY_NO    =   A.SKD_VOY_NO
              AND   B.SKD_DIR_CD    =   A.SKD_DIR_CD
              AND   B.REV_DIR_CD    =   A.REV_DIR_CD
              AND   A.ACT_DT        <=  TO_DATE(TO_CHAR(LAST_DAY(TO_DATE(pi_exeMonth, 'YYYYMM')), 'YYYYMMDD')||'235959', 'YYYYMMDDHH24MISS')
              AND   NVL(A.ACCL_FLG, 'Y') = 'Y'
            UNION   ALL
            --Rev Month가 Accrula Month기준으로 6 months 이전데이타는 cancelFlag 'Y'로 accrual Data 생성
            SELECT  pi_exeMonth                                                     AS  EXE_YRMON               --1
                ,	A.REV_YRMON             										AS  REV_YRMON
                ,	A.ACCT_CD               										AS  ACCT_CD
                ,	A.VSL_CD                										AS  VSL_CD
                ,	A.SKD_VOY_NO            										AS  SKD_VOY_NO              --5
                ,   A.SKD_DIR_CD            										AS  SKD_DIR_CD
                ,	A.REV_DIR_CD            										AS  REV_DIR_CD              
                ,	NULL        										            AS  ESTM_VVD_TP_CD          
                ,	NULL      										                AS  ESTM_IOC_DIV_CD
                ,	NULL        										            AS  ESTM_BC_DIV_CD          --10
                ,	A.N1ST_NOD_CD           										AS  NOD_CD
                ,	NVL(A.ESTM_COST_AMT, 0) 										AS  ESTM_COST_AMT           
                ,	NVL(A.ESTM_COST_AMT, 0) 										AS  ACCL_COST_AMT           
                ,	A.BKG_NO                										AS  BKG_NO
                ,	A.CNTR_TPSZ_CD          										AS  CNTR_TPSZ_CD            --15
                ,	A.RLANE_CD              										AS  RLANE_CD
                ,	NVL(A.CNTR_QTY, 0)      										AS  CNTR_QTY                
                ,	NVL(A.CNTR_QTY, 0)      										AS  ESTM_QTY                
                ,	NVL(A.CNTR_QTY, 0)      										AS  ACCL_QTY
                ,	A.N1ST_VNDR_SEQ         										AS  VNDR_NO                 --20
                ,	NVL(A.ESTM_UC_AMT, 0)   										AS  ESTM_UC_AMT
                ,	A.COA_COST_SRC_CD       										AS  COA_COST_SRC_CD         
                ,   A.LOCL_CURR_CD             										AS  LOCL_CURR_CD            
                ,   SUBSTR(A.RLANE_CD,1,3)                  						AS  SLAN_CD
                ,   A.ACT_DT                                                        AS  ACT_DT                  --25
                ,	'Y'                 										    AS  CXL_FLG                 
                ,   A.CTRL_OFC_CD                                                   AS  CTRL_OFC_CD             --27
            FROM    (
                        SELECT  XX.*
                        FROM
                        (
                            SELECT  RANK() OVER(PARTITION BY X.BKG_NO ORDER BY X.BKG_UPD_DT DESC) LST_SEQ
                                ,   X.*
                            FROM    SAC_TML_ESTM_COST_IF X
                        ) XX
                        WHERE   XX.LST_SEQ = 1
                    )                           A
            WHERE   1 = 1
              AND   A.REV_YRMON IS NOT NULL
            --AND   NVL(A.ESTM_COST_AMT, 0) > 0
              AND   A.REV_YRMON < TO_CHAR(ADD_MONTHS(TO_DATE(pi_exeMonth,'YYYYMM'), -6), 'YYYYMM')
              AND   NVL(A.ACCL_FLG, 'Y') = 'Y'
        ) AA;

        BEGIN
            FOR ACCL IN
            (
                SELECT  ACCL.BKG_NO
                    ,   ACCL.CNTR_TPSZ_CD
                    ,   ACCL.VSL_CD
                    ,   ACCL.SKD_VOY_NO
                    ,   ACCL.SKD_DIR_CD
                    ,   ACCL.REV_DIR_CD
                    ,   ACCL.NOD_CD
                    ,   ACCL.VNDR_NO
                    ,   ACCL.COA_COST_SRC_CD
                    ,   ACCL.LOCL_CURR_CD
                    ,   ACCL.ACCT_CD
                FROM    SAC_TML_ACCL_COST_IF    ACCL
                WHERE   1 = 1
                  AND   ACCL.EXE_YRMON = pi_exeMonth
            )
            LOOP
                R_ACT_AMT       :=  NULL;
                R_ACT_QTY       :=  NULL;
                R_ACT_PLC_CD    :=  NULL;
                R_ACT_DT        :=  NULL;
                
                BEGIN
                    SELECT  SUM(NVL(ACT.LOCL_COST_AMT, 0))
                        ,   SUM(NVL(ACT.CNTR_QTY, 0))
                        ,   MAX(ACT.ACT_PLC_CD)
                        ,   MAX(ACT.ACT_DT)
                    INTO    R_ACT_AMT
                        ,   R_ACT_QTY
                        ,   R_ACT_PLC_CD
                        ,   R_ACT_DT
                    FROM    SAC_TML_ACT_COST_IF     ACT
                    WHERE   1 = 1
                      AND   ACT.EXE_YRMON               =   pi_exeMonth
                      AND   NVL(ACT.INV_CXL_FLG,'N')    =   'N'
                      AND   ACT.ACT_DT                  <=  TO_DATE(TO_CHAR(LAST_DAY(TO_DATE(pi_exeMonth, 'YYYYMM')), 'YYYYMMDD')||'235959', 'YYYYMMDDHH24MISS')
                      AND   ACT.BKG_NO                  =   ACCL.BKG_NO
                      AND   ACT.CNTR_TPSZ_CD            =   ACCL.CNTR_TPSZ_CD
                      AND   ACT.VSL_CD                  =   ACCL.VSL_CD
                      AND   ACT.SKD_VOY_NO              =   ACCL.SKD_VOY_NO
                      AND   ACT.SKD_DIR_CD              =   ACCL.SKD_DIR_CD
                      AND   ACT.REV_DIR_CD              =   ACCL.REV_DIR_CD
                      AND   ACT.N1ST_NOD_CD             =   ACCL.NOD_CD
                      AND   ACT.INV_VNDR_SEQ            =   ACCL.VNDR_NO
                      AND   ACT.COA_COST_SRC_CD         =   ACCL.COA_COST_SRC_CD
                      AND   ACT.LOCL_CURR_CD            =   ACCL.LOCL_CURR_CD
                      AND   ACT.ACCT_CD                 =   ACCL.ACCT_CD
                    GROUP BY    ACT.BKG_NO
                        ,       ACT.CNTR_TPSZ_CD
                        ,       ACT.VSL_CD
                        ,       ACT.SKD_VOY_NO
                        ,       ACT.SKD_DIR_CD
                        ,       ACT.REV_DIR_CD
                        ,       ACT.N1ST_NOD_CD
                        ,       ACT.INV_VNDR_SEQ
                        ,       ACT.COA_COST_SRC_CD;
                EXCEPTION
                    WHEN OTHERS THEN
                        R_ACT_AMT       :=  NULL;
                        R_ACT_QTY       :=  NULL;
                        R_ACT_PLC_CD    :=  NULL;
                        R_ACT_DT        :=  NULL;
                END;

                IF R_ACT_QTY IS NOT NULL AND R_ACT_AMT IS NOT NULL THEN
                    BEGIN
                        UPDATE  SAC_TML_ACCL_COST_IF
                        SET     ACT_QTY         =   R_ACT_QTY
                            ,   ACCL_QTY        =   ESTM_QTY - R_ACT_QTY
                            ,   ACT_COST_AMT    =   ROUND(R_ACT_AMT, SAC_BRG_IF_PKG.GET_AMT_PRECISION(ACCL.LOCL_CURR_CD))
                            ,   ACCL_COST_AMT   =   ROUND((ESTM_QTY - R_ACT_QTY) * NVL(ESTM_UC_AMT, 0), SAC_BRG_IF_PKG.GET_AMT_PRECISION(ACCL.LOCL_CURR_CD))
                            ,   ACT_PLC_CD      =   R_ACT_PLC_CD
                            ,   ACT_DT          =   R_ACT_DT
                            ,   UPD_DT          =   SYSDATE
                        WHERE   1 = 1
                          AND   EXE_YRMON       =   pi_exeMonth
                          AND   BKG_NO          =   ACCL.BKG_NO
                          AND   CNTR_TPSZ_CD    =   ACCL.CNTR_TPSZ_CD
                          AND   VSL_CD          =   ACCL.VSL_CD
                          AND   SKD_VOY_NO      =   ACCL.SKD_VOY_NO
                          AND   SKD_DIR_CD      =   ACCL.SKD_DIR_CD
                          AND   REV_DIR_CD      =   ACCL.REV_DIR_CD
                          AND   NOD_CD          =   ACCL.NOD_CD
                          AND   VNDR_NO         =   ACCL.VNDR_NO
                          AND   COA_COST_SRC_CD =   ACCL.COA_COST_SRC_CD
                          AND   LOCL_CURR_CD    =   ACCL.LOCL_CURR_CD
                          AND   ACCT_CD         =   ACCL.ACCT_CD;
                    EXCEPTION
                        WHEN OTHERS THEN
                            ERRMSG := SQLERRM || '(Error in Actual data updating)';
                            RAISE my_exception;
                    END;
                END  IF;
            END LOOP;
        EXCEPTION
            WHEN OTHERS THEN
                ERRMSG := SQLERRM || '(Error in Actual data mapping)';
                RAISE my_exception;
        END;

        -- Cancellation setUp
        BEGIN
            FOR CANCEL IN
            (
                SELECT  VSL_CD
                    ,   SKD_VOY_NO
                    ,   SKD_DIR_CD
                    ,   REV_DIR_CD
                    ,   NOD_CD
                    ,   VNDR_NO
                    ,   COA_COST_SRC_CD
                    ,   SUM(NVL(ESTM_QTY        , 0))   AS  ESTM_QTY
                    ,   SUM(NVL(ESTM_COST_AMT   , 0))   AS  ESTM_AMT
                    ,   SUM(NVL(ACT_QTY         , 0))   AS  ACT_QTY
                    ,   SUM(NVL(ACT_COST_AMT    , 0))   AS  ACT_AMT
                    ,   SUM(NVL(ACCL_QTY        , 0))   AS  ACCL_QTY
                    ,   SUM(NVL(ACCL_COST_AMT   , 0))   AS  ACCL_AMT
                    ,   CASE
                            WHEN    
                                SUM(NVL(ESTM_QTY, 0)) > SUM(NVL(ACT_QTY, 0)) 
                                AND 
                                SUM(NVL(ESTM_COST_AMT, 0)) > SUM(NVL(ACT_COST_AMT, 0)) 
                            THEN
                                CASE
                                    WHEN    
                                        99  < (SUM(NVL(ACT_COST_AMT, 0)) / SUM(NVL(ESTM_COST_AMT, 0))) * 100
                                        AND 
                                        100 > (SUM(NVL(ACT_COST_AMT, 0)) / SUM(NVL(ESTM_COST_AMT, 0))) * 100 
                                    THEN
                                        'Y'
                                    ELSE
                                        'N'
                                END
                            ELSE
                                'Y'
                        END                             AS  CANCEL_FLAG
                FROM    SAC_TML_ACCL_COST_IF
                WHERE   1 = 1
                  AND   EXE_YRMON = pi_exeMonth
                GROUP BY    VSL_CD
                        ,   SKD_VOY_NO
                        ,   SKD_DIR_CD
                        ,   REV_DIR_CD
                        ,   NOD_CD
                        ,   VNDR_NO
                        ,   COA_COST_SRC_CD
            )
            LOOP
                IF  CANCEL.CANCEL_FLAG = 'Y' THEN
                    UPDATE  SAC_TML_ACCL_COST_IF
                    SET     CXL_FLG         =   'Y'
                        ,   CXL_DT          =   SYSDATE
                        ,   UPD_DT          =   SYSDATE
                        ,   ACCL_COST_AMT   =   0
                    WHERE   1 = 1
                      AND   EXE_YRMON       =   pi_exeMonth
                      AND   VSL_CD          =   CANCEL.VSL_CD
                      AND   SKD_VOY_NO      =   CANCEL.SKD_VOY_NO
                      AND   SKD_DIR_CD      =   CANCEL.SKD_DIR_CD
                      AND   REV_DIR_CD      =   CANCEL.REV_DIR_CD
                      AND   NOD_CD          =   CANCEL.NOD_CD
                      AND   VNDR_NO         =   CANCEL.VNDR_NO
                      AND   COA_COST_SRC_CD =   CANCEL.COA_COST_SRC_CD;
                END IF;
            END LOOP;
        EXCEPTION
            WHEN OTHERS THEN
                ERRMSG := SQLERRM || '(Error in AutoCancellation Processing)';
                RAISE my_exception;
        END;

        INSERT INTO SAC_COST_ACCL_INFO
        (
                EXE_YRMON           --1
        	,	SYS_SRC_ID      
          	,	REV_YRMON       
          	,	ACCT_CD         
          	,	ESTM_SEQ_NO         --5
          	,	BIZ_UT_ID       
          	,	LOC_CD          
          	,	VSL_CD          
          	,	SKD_VOY_NO      
          	,	SKD_DIR_CD          --10
          	,	REV_DIR_CD      
          	,	CNTR_TPSZ_CD    
          	,	CNTR_QTY        
          	,	CUST_SEQ        
          	,	ESTM_AMT            --15
          	,	ACT_AMT         
          	,	ACCL_AMT        
          	,	ESTM_VVD_TP_CD  
          	,	ESTM_IOC_DIV_CD 
          	,	ESTM_BC_DIV_CD      --20
          	,	OP_LSE_DIV_FLG  
          	,	VNDR_INV_NO     
          	,	LOCL_CURR_CD    
          	,	ACT_DT          
          	,	ACT_PLC_CD          --25
          	,	SLAN_CD
            ,   COST_ACT_PLC_CD
            ,   CRE_USR_ID
            ,   CRE_DT              
            ,   UPD_USR_ID          --30
            ,   UPD_DT              
            ,   ACCL_FLG            
            ,   CTRL_OFC_CD         --33
        )
        SELECT 	A.EXE_YRMON                                                                     AS  EXE_YRMON           --1
        	,	'TES'                           								                AS  SYS_SRC_ID
          	,	A.REV_YRMON                     								                AS  REV_YRMON
          	,	A.ACCT_CD                       								                AS  ACCT_CD
          	,	ROW_NUMBER() OVER (ORDER BY A.EXE_YRMON,A.REV_YRMON,A.ACCT_CD)                  AS  ESTM_SEQ_NO         --5
          	,	'CNTR'                          								                AS  BIZ_UT_ID
          	,   A.ACT_PLC_CD                    								                AS  LOC_CD
          	,	A.VSL_CD                        								                AS  VSL_CD
          	,	A.SKD_VOY_NO                    								                AS  SKD_VOY_NO
          	,	A.SKD_DIR_CD                    								                AS  SKD_DIR_CD          --10
          	,	A.REV_DIR_CD                    								                AS  REV_DIR_CD
          	,	A.CNTR_TPSZ_CD                  								                AS  CNTR_TPSZ_CD
          	,	A.ACCL_QTY                      								                AS  CNTR_QTY
          	,	TO_NUMBER(A.VNDR_NO)            								                AS  CUST_SEQ
          	,	ROUND(A.ESTM_COST_AMT   , SAC_BRG_IF_PKG.GET_AMT_PRECISION(A.LOCL_CURR_CD))     AS  ESTM_AMT            --15
          	,	ROUND(A.ACT_COST_AMT    , SAC_BRG_IF_PKG.GET_AMT_PRECISION(A.LOCL_CURR_CD))     AS  ACT_AMT
          	,	ROUND(A.ACCL_COST_AMT   , SAC_BRG_IF_PKG.GET_AMT_PRECISION(A.LOCL_CURR_CD))     AS  ACCL_AMT
          	,	A.ESTM_VVD_TP_CD                								                AS  ESTM_VVD_TP_CD
          	,	A.ESTM_IOC_DIV_CD               								                AS  ESTM_IOC_DIV_CD
          	,	A.ESTM_BC_DIV_CD                								                AS  ESTM_BC_DIV_CD      --20
          	,	'N'                             								                AS  OP_LSE_DIV_FLG
          	,	A.VNDR_NO                       								                AS  VNDR_INV_NO
          	,	A.LOCL_CURR_CD                  								                AS  LOCL_CURR_CD
          	,	TO_CHAR(A.ACT_DT, 'YYYYMMDD')   								                AS  ACT_DT
          	,	A.ACT_PLC_CD                    								                AS  ACT_PLC_CD          --25
          	,	A.SLAN_CD                       								                AS  SLAN_CD
            ,   A.NOD_CD                        								                AS  COST_ACT_PLC_CD
            ,   NVL(pi_user_id, 'SYSTEM')                        				                AS  CRE_USR_ID
            ,   SYSDATE                         								                AS  CRE_DT              
            ,   NVL(pi_user_id, 'SYSTEM')                        				                AS  UPD_USR_ID          --30
            ,   SYSDATE                         								                AS  UPD_DT              
            ,   'Y'                                                                             AS  ACCL_FLG
            ,   A.CTRL_OFC_CD                                                                   AS  CTRL_OFC_CD         --33
        FROM    SAC_TML_ACCL_COST_IF A
        WHERE   1 = 1
          AND   A.EXE_YRMON = pi_exeMonth
          AND   NVL(A.CXL_FLG, 'N') = 'N';
        
        --Mandatory items missing check...
        UPDATE  SAC_TML_ACCL_COST_IF T
        SET     ERR_FLG     =   'Y'
            ,   ERR_DESC    =   'Critical items is missing(AcclAmt, SLane, Node, ActDt, ActPlc, Vendor, Curr, Ofc, RevVVD, Acct)'
        WHERE   EXE_YRMON = pi_exeMonth
          AND   NVL(CXL_FLG, 'N') = 'N'
          AND   (
                        ACCL_COST_AMT   IS NULL
                    OR  SLAN_CD         IS NULL
                    OR  NOD_CD          IS NULL 
                    OR  ACT_DT          IS NULL 
                    OR  VNDR_NO         IS NULL 
                    OR  LOCL_CURR_CD    IS NULL  
                    OR  CTRL_OFC_CD     IS NULL  
                    OR  VSL_CD          IS NULL 
                    OR  SKD_VOY_NO      IS NULL 
                    OR  SKD_DIR_CD      IS NULL 
                    OR  REV_DIR_CD      IS NULL
                    OR  ACCT_CD         IS NULL
                )
        ;

        --Package Execution End Log Update...
        UPDATE  SAC_IF_ERR_LOG
        SET     ATTR_CTNT3  =   'END'
            ,   UPD_DT      =   SYSDATE
            ,   ATTR_CTNT5  =   FLOOR((SYSDATE-CRE_DT)*24) || '''' || FLOOR(MOD((SYSDATE-CRE_DT)*24,1)*60) || '''' || TRUNC(ROUND(MOD((SYSDATE-CRE_DT)*24*60,1)*60))
        WHERE   1 = 1
          AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'
          AND   SRC_MDL_CD  = 'ACCLTES'
          AND   ERR_DESC    = 'EXEC_LOG'
          AND   EXE_YRMON   = pi_exeMonth
          AND   ATTR_CTNT1  = TO_CHAR(SYSDATE, 'YYYYMMDD')
          AND   ATTR_CTNT2  = R_EXEC_CNT
        ;
        COMMIT;
        
        po_result := 'S';

    EXCEPTION
        WHEN my_exception THEN
            ROLLBACK;
            
            IF ERRMSG IS NULL THEN
                ERRMSG := SQLERRM;
            END IF;

            SCO_ERR_LOG_PRC('SAC_TRS_TES_ACCRUAL_PKG.TES_ACCRUAL_INSERT', ERRMSG, pi_exeMonth, 'ACCRUAL');

            --Package Execution End Log Update...
            UPDATE  SAC_IF_ERR_LOG
            SET     ATTR_CTNT3  =   'FAIL'
                ,   UPD_DT      =   SYSDATE
                ,   ATTR_CTNT5  =   FLOOR((SYSDATE-CRE_DT)*24) || '''' || FLOOR(MOD((SYSDATE-CRE_DT)*24,1)*60) || '''' || TRUNC(ROUND(MOD((SYSDATE-CRE_DT)*24*60,1)*60))
            WHERE   1 = 1
              AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'
              AND   SRC_MDL_CD  = 'ACCLTES'
              AND   ERR_DESC    = 'EXEC_LOG'
              AND   EXE_YRMON   = pi_exeMonth
              AND   ATTR_CTNT1  = TO_CHAR(SYSDATE, 'YYYYMMDD')
              AND   ATTR_CTNT2  = R_EXEC_CNT
            ;
            COMMIT;
        
            po_result := 'E';

        WHEN OTHERS THEN
            ROLLBACK;
            
            IF ERRMSG IS NULL THEN
                ERRMSG := SQLERRM;
            END IF;
            
            SCO_ERR_LOG_PRC('SAC_TRS_TES_ACCRUAL_PKG.TES_ACCRUAL_INSERT', ERRMSG, pi_exeMonth, 'ACCRUAL');

            --Package Execution End Log Update...
            UPDATE  SAC_IF_ERR_LOG
            SET     ATTR_CTNT3  =   'FAIL'
                ,   UPD_DT      =   SYSDATE
                ,   ATTR_CTNT5  =   FLOOR((SYSDATE-CRE_DT)*24) || '''' || FLOOR(MOD((SYSDATE-CRE_DT)*24,1)*60) || '''' || TRUNC(ROUND(MOD((SYSDATE-CRE_DT)*24*60,1)*60))
            WHERE   1 = 1
              AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'
              AND   SRC_MDL_CD  = 'ACCLTES'
              AND   ERR_DESC    = 'EXEC_LOG'
              AND   EXE_YRMON   = pi_exeMonth
              AND   ATTR_CTNT1  = TO_CHAR(SYSDATE, 'YYYYMMDD')
              AND   ATTR_CTNT2  = R_EXEC_CNT
            ;
            COMMIT;
        
            po_result := 'E';

    END TES_ACCRUAL_INSERT;

    --pi_exeMonth : accrual Month
    --pi_user_id : OPUS User ID
    PROCEDURE TRS_ACCRUAL_INSERT
    (
            pi_exeMonth     IN  VARCHAR2
        ,   pi_user_id      IN  VARCHAR2
        ,   po_result       OUT VARCHAR2
    )
    IS
        R_ACT_AMT           NUMBER          :=  NULL;
        R_EXEC_CNT          NUMBER          :=  0;
        
        ERRMSG              VARCHAR2(4000)  :=  NULL;
        R_INV_VNDR_SEQ      VARCHAR2(6)     :=  NULL;
        R_ACT_PLC_CD        VARCHAR2(5)     :=  NULL;
        
        R_ACT_DT            DATE            :=  NULL;

        my_exception        EXCEPTION;
    BEGIN
        SELECT  TO_NUMBER(NVL(MAX(ATTR_CTNT2), '0')) + 1
        INTO    R_EXEC_CNT
        FROM    SAC_IF_ERR_LOG
        WHERE   1 = 1
          AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'
          AND   SRC_MDL_CD  = 'ACCLTRS'
          AND   ERR_DESC    = 'EXEC_LOG'
          AND   EXE_YRMON   = pi_exeMonth
          AND   ATTR_CTNT1  = TO_CHAR(SYSDATE, 'YYYYMMDD')
        ;

        --Package Execution Start Log Insert...
        SCO_ERR_LOG_PRC
        (
            	PI_PGM_APPL_NM 	=>	'SAC_TRS_TES_ACCRUAL_PKG'
            ,   PI_ERR_DESC   	=>	'EXEC_LOG'
            ,   PI_EXE_YRMON  	=>  pi_exeMonth
            ,   PI_MOD_NAME   	=>	'ACCLTRS'
            ,   PI_ATTR_CTNT1 	=>	TO_CHAR(SYSDATE, 'YYYYMMDD')
            ,   PI_ATTR_CTNT2 	=>	R_EXEC_CNT
            ,   PI_ATTR_CTNT3 	=>	'START'
            ,	PI_ATTR_CTNT4 	=>	''	
            ,	PI_ATTR_CTNT5 	=>	''  	
        );
        
        --Dup Data Delete...
        DELETE FROM SAC_TRSP_ACCL_COST_IF WHERE EXE_YRMON = pi_exeMonth;
        DELETE FROM SAC_COST_ACCL_INFO    WHERE SYS_SRC_ID = 'TRS' AND EXE_YRMON = pi_exeMonth;

        INSERT INTO SAC_TRSP_ACCL_COST_IF
        (
            	EXE_YRMON           --1
            ,	SYS_SRC_ID
            ,	REV_YRMON
            ,	ACCT_CD
            ,	ACCL_SEQ            --5        
            ,	BIZ_UT_ID
            ,	VSL_CD
            ,	SKD_VOY_NO
            ,	SKD_DIR_CD
            ,	REV_DIR_CD          --10
            ,	ESTM_VVD_TP_CD
            ,	ESTM_IOC_DIV_CD
            ,	ESTM_BC_DIV_CD
            ,	NOD_CD
            ,	ESTM_COST_AMT       --15
            ,	ACCL_COST_AMT
            ,	COA_COST_SRC_CD
            ,   ACT_PLC_CD
            ,   ACT_DT
            ,   LOCL_CURR_CD        --20
            ,   SLAN_CD
            ,   VNDR_NO
            ,   WO_NO
            ,	CRE_USR_ID
            ,	CRE_DT              --25
            ,	UPD_USR_ID
            ,	UPD_DT              
            ,   CTRL_OFC_CD         --28
        )
        SELECT  EXE_YRMON                                                               AS  EXE_YRMON            --1
            ,	'TRS'                   				                                AS  SYS_SRC_ID
            ,	REV_YRMON                                                               AS  REV_YRMON
            ,	ACCT_CD                                                                 AS  ACCT_CD
            ,	ROW_NUMBER() OVER (ORDER BY EXE_YRMON, ACCT_CD)                         AS  ACCL_SEQ            --5
            ,	'CNTR'                  							                    AS  BIZ_UT_ID
            ,	VSL_CD                                                                  AS  VSL_CD
            ,	SKD_VOY_NO                                                              AS	SKD_VOY_NO      
            ,   SKD_DIR_CD                                                              AS  SKD_DIR_CD      
            ,	REV_DIR_CD                                                              AS  REV_DIR_CD          --10
            ,	ESTM_VVD_TP_CD                                                          AS  ESTM_VVD_TP_CD  
            ,	ESTM_IOC_DIV_CD                                                         AS  ESTM_IOC_DIV_CD 
            ,	ESTM_BC_DIV_CD                                                          AS  ESTM_BC_DIV_CD  
            ,	NOD_CD                                                                  AS  NOD_CD          
            ,	ROUND(ESTM_COST_AMT, SAC_BRG_IF_PKG.GET_AMT_PRECISION(LOCL_CURR_CD))    AS  ESTM_COST_AMT       --15
            ,	ROUND(ACCL_COST_AMT, SAC_BRG_IF_PKG.GET_AMT_PRECISION(LOCL_CURR_CD))    AS  ACCL_COST_AMT   
            ,	COA_COST_SRC_CD                                                         AS  COA_COST_SRC_CD       
            ,   ACT_PLC_CD                                                              AS  ACT_PLC_CD      
            ,   ACT_DT                                                                  AS  ACT_DT          
            ,   LOCL_CURR_CD                                                            AS  LOCL_CURR_CD        --20
            ,   SLAN_CD                                                                 AS  SLAN_CD         
            ,   INV_VNDR_SEQ                                                            AS  INV_VNDR_SEQ          
            ,   WO_NO                 							                        AS  WO_NO             
            ,	NVL(pi_user_id, 'SYSTEM')                			                    AS  CRE_USR_ID
            ,	SYSDATE                 							                    AS  CRE_DT              --25
            ,	NVL(pi_user_id, 'SYSTEM')                 			                    AS  UPD_USR_ID
            ,	SYSDATE                 							                    AS  UPD_DT      
            ,   CTRL_OFC_CD                                                             AS  CTRL_OFC_CD         --28
        FROM
        (
            SELECT  ESTM.WO_NO                      AS  WO_NO
                ,   GL.EXE_YRMON                    AS  EXE_YRMON
                ,	GL.REV_YRMON             		AS  REV_YRMON           
                ,	ESTM.ACCT_CD               	    AS  ACCT_CD
                ,	ESTM.VSL_CD                	 	AS  VSL_CD              
                ,	ESTM.SKD_VOY_NO            	 	AS  SKD_VOY_NO          
                ,   ESTM.SKD_DIR_CD            	 	AS  SKD_DIR_CD          
                ,	ESTM.REV_DIR_CD            	 	AS  REV_DIR_CD          
                ,	GL.ESTM_VVD_TP_CD        	 	AS  ESTM_VVD_TP_CD      
                ,	GL.ESTM_IOC_DIV_CD       	 	AS  ESTM_IOC_DIV_CD     
                ,	GL.ESTM_BC_DIV_CD        	 	AS  ESTM_BC_DIV_CD      
                ,	ESTM.N1ST_NOD_CD           	 	AS  NOD_CD
                ,	ESTM.COA_COST_SRC_CD       	 	AS  COA_COST_SRC_CD
                ,   ESTM.ACT_PLC_CD            	 	AS  ACT_PLC_CD
                ,   ESTM.ACT_DT                	 	AS  ACT_DT
                ,   ESTM.LOCL_CURR_CD          	 	AS  LOCL_CURR_CD
                ,   ESTM.SLAN_CD               	 	AS  SLAN_CD
                ,   ESTM.INV_VNDR_SEQ               AS  INV_VNDR_SEQ
                ,	NVL(ESTM.LOCL_COST_AMT, 0) 	 	AS  ESTM_COST_AMT
                ,	NVL(ESTM.LOCL_COST_AMT, 0) 	 	AS  ACCL_COST_AMT
                ,   ESTM.CTRL_OFC_CD             	AS  CTRL_OFC_CD
            FROM    (
                        --MIS에서 ACCL로 EDW_UDP_DT기준 Daily ETL I/F하는 관계로 W/O데이타중 최신데이타만 추출해서 사용...
                        --Partition by 항목에 대해 추후 데이타분석후 변경가능
                        SELECT  XX.*
                        FROM
                        (
                            SELECT  DENSE_RANK() OVER(PARTITION BY X.WO_NO ORDER BY TO_CHAR(X.UPD_DT,'YYYYMMDD') DESC) LST_SEQ    
                                ,   X.*
                            FROM    SAC_TRSP_ESTM_ACT_IF X
                            WHERE   1 = 1
                              AND   X.ESTM_ACT_DIV_CD = 'E'
                        ) XX
                        WHERE   1 = 1
                          AND   XX.LST_SEQ = 1
                          AND   NVL(XX.CXL_FLG, 'N') = 'N'
                    )                       ESTM    
                ,   SAC_ESTM_REV_VVD        GL
            WHERE   1 = 1
              AND   GL.EXE_YRMON                =   pi_exeMonth
              AND   ESTM.VSL_CD                 =   GL.VSL_CD
              AND   ESTM.SKD_VOY_NO             =   GL.SKD_VOY_NO
              AND   ESTM.SKD_DIR_CD             =   GL.SKD_DIR_CD
              AND   ESTM.REV_DIR_CD             =   GL.REV_DIR_CD
              AND   ESTM.ACT_DT                 <=  TO_DATE(TO_CHAR(LAST_DAY(TO_DATE(pi_exeMonth, 'YYYYMM')), 'YYYYMMDD')||'235959', 'YYYYMMDDHH24MISS')
              AND   NVL(ESTM.LOCL_COST_AMT, 0)  > 0
        )
        WHERE   1 = 1;

        BEGIN
            FOR ACCL IN
            (
                SELECT  WO_NO           
                    ,   ACCT_CD         
                    ,   COA_COST_SRC_CD 
                    ,   LOCL_CURR_CD    
                    ,   VSL_CD          
                    ,   SKD_VOY_NO      
                    ,   SKD_DIR_CD      
                    ,   REV_DIR_CD      
                    ,   NOD_CD     
                FROM    SAC_TRSP_ACCL_COST_IF
                WHERE   1 = 1
                  AND   EXE_YRMON = pi_exeMonth
            )
            LOOP
                R_ACT_AMT           :=  NULL;
                R_INV_VNDR_SEQ      :=  NULL;
                R_ACT_PLC_CD        :=  NULL;
                R_ACT_DT            :=  NULL;

                BEGIN
                    SELECT  /*
                            SUM(NVL(ACT.LOCL_COST_AMT, 0))
                        ,   MAX(ACT.ACT_PLC_CD)
                        ,   MAX(ACT.ACT_DT)
                        ,   MAX(ACT.INV_VNDR_SEQ)
                            */
                            DISTINCT
                            NVL(ACT.LOCL_COST_AMT, 0)
                        ,   ACT.ACT_PLC_CD
                        ,   ACT.ACT_DT
                        ,   ACT.INV_VNDR_SEQ
                    INTO    R_ACT_AMT
                        ,   R_ACT_PLC_CD
                        ,   R_ACT_DT
                        ,   R_INV_VNDR_SEQ
                    FROM    (
                                --MIS에서 ACCL로 EFW_UDP_DT기준 Daily ETL I/F하는 관계로 W/O데이타중 최신데이만 추출해서 사용...
                                --Partition by 항목에 대해 추후 데이타분석후 변경가능
                                SELECT  XX.*
                                FROM
                                (
                                    SELECT  DENSE_RANK() OVER(PARTITION BY X.WO_NO ORDER BY TO_CHAR(X.UPD_DT,'YYYYMMDD') DESC) LST_SEQ    
                                        ,   X.*
                                    FROM    SAC_TRSP_ESTM_ACT_IF X
                                    WHERE   1 = 1
                                      AND   X.ESTM_ACT_DIV_CD = 'A'
                                ) XX
                                WHERE   1 = 1
                                  AND   XX.LST_SEQ = 1
                                  AND   NVL(XX.CXL_FLG, 'N') = 'N'
                            ) ACT
                        ,   SAC_ESTM_REV_VVD        GL
                    WHERE   1 = 1
                      AND   GL.EXE_YRMON            =   pi_exeMonth
                      AND   ACT.VSL_CD              =   GL.VSL_CD
                      AND   ACT.SKD_VOY_NO          =   GL.SKD_VOY_NO
                      AND   ACT.SKD_DIR_CD          =   GL.SKD_DIR_CD
                      AND   ACT.REV_DIR_CD          =   GL.REV_DIR_CD
                      AND   ACT.ACT_DT              <=  TO_DATE(TO_CHAR(LAST_DAY(TO_DATE(pi_exeMonth, 'YYYYMM')), 'YYYYMMDD')||'235959', 'YYYYMMDDHH24MISS')
                      AND   ACT.WO_NO               =   ACCL.WO_NO
                      AND   ACT.ACCT_CD             =   ACCL.ACCT_CD
                      AND   ACT.COA_COST_SRC_CD     =   ACCL.COA_COST_SRC_CD
                      AND   ACT.LOCL_CURR_CD        =   ACCL.LOCL_CURR_CD
                      AND   ACT.VSL_CD              =   ACCL.VSL_CD     
                      AND   ACT.SKD_VOY_NO          =   ACCL.SKD_VOY_NO
                      AND   ACT.SKD_DIR_CD          =   ACCL.SKD_DIR_CD
                      AND   ACT.REV_DIR_CD          =   ACCL.REV_DIR_CD
                      AND   ACT.N1ST_NOD_CD         =   ACCL.NOD_CD
                      AND   ROWNUM < 2
                  --GROUP BY ACT.WO_NO
                    ;
                EXCEPTION
                    WHEN OTHERS THEN
                        R_ACT_AMT           :=  NULL;
                        R_ACT_PLC_CD        :=  NULL;
                        R_ACT_DT            :=  NULL;
                        R_INV_VNDR_SEQ      :=  NULL;
                END;

                IF R_ACT_AMT IS NOT NULL THEN
                    BEGIN
                        UPDATE  SAC_TRSP_ACCL_COST_IF
                        SET     ACT_COST_AMT        =   ROUND(NVL(R_ACT_AMT, 0), SAC_BRG_IF_PKG.GET_AMT_PRECISION(LOCL_CURR_CD))
                            ,   ACCL_COST_AMT       =   NVL(ESTM_COST_AMT, 0) - ROUND(NVL(R_ACT_AMT, 0), SAC_BRG_IF_PKG.GET_AMT_PRECISION(ACCL.LOCL_CURR_CD))
                            ,   ACT_PLC_CD          =   R_ACT_PLC_CD
                            ,   ACT_DT              =   R_ACT_DT
                            ,   VNDR_NO             =   R_INV_VNDR_SEQ
                            ,   UPD_DT              =   SYSDATE
                        WHERE   1 = 1
                          AND   EXE_YRMON           =   pi_exeMonth
                          AND   WO_NO               =   ACCL.WO_NO
                          AND   ACCT_CD             =   ACCL.ACCT_CD
                          AND   COA_COST_SRC_CD     =   ACCL.COA_COST_SRC_CD
                          AND   LOCL_CURR_CD        =   ACCL.LOCL_CURR_CD
                          AND   VSL_CD              =   ACCL.VSL_CD     
                          AND   SKD_VOY_NO          =   ACCL.SKD_VOY_NO
                          AND   SKD_DIR_CD          =   ACCL.SKD_DIR_CD
                          AND   REV_DIR_CD          =   ACCL.REV_DIR_CD
                          AND   NOD_CD              =   ACCL.NOD_CD;
                    EXCEPTION
                        WHEN OTHERS THEN
                            ERRMSG := SQLERRM || '(Error in Actual data updating)';
                            RAISE my_exception;
                    END;
                END  IF;
            END LOOP;
        EXCEPTION
            WHEN OTHERS THEN
                ERRMSG := SQLERRM || '(Error in Actual data mapping)';
                RAISE my_exception;
        END;

        INSERT INTO SAC_COST_ACCL_INFO
        (
                EXE_YRMON           --1
        	,	SYS_SRC_ID      
          	,	REV_YRMON       
          	,	ACCT_CD         
          	,	ESTM_SEQ_NO         --5
          	,	WO_NO           
          	,	BIZ_UT_ID       
          	,	LOC_CD          
          	,	VSL_CD          
          	,	SKD_VOY_NO          --10
          	,	SKD_DIR_CD      
          	,	REV_DIR_CD      
          	,	CNTR_TPSZ_CD    
          	,	CNTR_QTY        
          	,	CUST_SEQ            --15
          	,	ESTM_AMT        
          	,	ACT_AMT         
          	,	ACCL_AMT        
          	,	ESTM_VVD_TP_CD  
          	,	ESTM_IOC_DIV_CD     --20
          	,	ESTM_BC_DIV_CD  
          	,	OP_LSE_DIV_FLG  
          	,	VNDR_INV_NO     
          	,	LOCL_CURR_CD    
          	,	ACT_DT              --25
          	,	ACT_PLC_CD      
          	,	SLAN_CD
            ,   COST_ACT_PLC_CD
            ,   CRE_USR_ID          
            ,   CRE_DT              --30
            ,   UPD_USR_ID
            ,   UPD_DT              
            ,   ACCL_FLG
            ,   CTRL_OFC_CD         --34
        )
        SELECT 	A.EXE_YRMON                                                                     AS  EXE_YRMON           --1
        	,	'TRS'                                                                           AS  SYS_SRC_ID
          	,	A.REV_YRMON                                                                     AS  REV_YRMON
          	,	A.ACCT_CD                                                                       AS  ACCT_CD
          	,	ROW_NUMBER() OVER (ORDER BY A.EXE_YRMON,A.REV_YRMON,A.ACCT_CD)                  AS  ESTM_SEQ_NO         --5
            ,	A.WO_NO                                                                         AS  WO_NO
          	,	'CNTR'                                                      	                AS  BIZ_UT_ID
            ,   A.ACT_PLC_CD                                                	                AS  LOC_CD
          	,	A.VSL_CD                                                    	                AS  VSL_CD
          	,	A.SKD_VOY_NO                                                	                AS  SKD_VOY_NO          --10
          	,	A.SKD_DIR_CD                                                	                AS  SKD_DIR_CD
          	,	A.REV_DIR_CD                                                	                AS  REV_DIR_CD
          	,	A.CNTR_TPSZ_CD                                              	                AS  CNTR_TPSZ_CD
          	,	A.ACCL_QTY                                                  	                AS  CNTR_QTY
          	,	TO_NUMBER(A.VNDR_NO)                                        	                AS  CUST_SEQ            --15      
          	,	ROUND(A.ESTM_COST_AMT   , SAC_BRG_IF_PKG.GET_AMT_PRECISION(A.LOCL_CURR_CD))     AS  ESTM_AMT
          	,	ROUND(A.ACT_COST_AMT    , SAC_BRG_IF_PKG.GET_AMT_PRECISION(A.LOCL_CURR_CD))     AS  ACT_AMT
          	,	ROUND(A.ACCL_COST_AMT   , SAC_BRG_IF_PKG.GET_AMT_PRECISION(A.LOCL_CURR_CD))     AS  ACCL_AMT
          	,	A.ESTM_VVD_TP_CD                                            	                AS  ESTM_VVD_TP_CD
          	,	A.ESTM_IOC_DIV_CD                                           	                AS  ESTM_IOC_DIV_CD     --20
          	,	A.ESTM_BC_DIV_CD                                            	                AS  ESTM_BC_DIV_CD
          	,	'N'                                                         	                AS  OP_LSE_DIV_FLG
          	,	A.VNDR_NO                                                   	                AS  VNDR_INV_NO
          	,	A.LOCL_CURR_CD                                              	                AS  LOCL_CURR_CD
          	,	TO_CHAR(A.ACT_DT, 'YYYYMMDD')                               	                AS  ACT_DT              --25
          	,	A.ACT_PLC_CD                                                	                AS  ACT_PLC_CD
          	,	A.SLAN_CD                                                   	                AS  SLAN_CD
            ,   A.NOD_CD                                                    	                AS  COST_ACT_PLC_CD
            ,   NVL(pi_user_id, 'SYSTEM')                                                       AS  CRE_USR_ID          
            ,   SYSDATE                                                     	                AS  CRE_DT              --30
            ,   NVL(pi_user_id, 'SYSTEM')                                                       AS  UPD_USR_ID
            ,   SYSDATE                                                     	                AS  UPD_DT              
            ,   'Y'                                                                             AS  ACCL_FLG
            ,   A.CTRL_OFC_CD                                                                   AS  CTRL_OFC_CD         --34
        FROM    SAC_TRSP_ACCL_COST_IF A
        WHERE   1 = 1
          AND   A.EXE_YRMON = pi_exeMonth
          AND   NVL(A.CXL_FLG, 'N') = 'N';

        --Mandatory items missing check...
        UPDATE  SAC_TRSP_ACCL_COST_IF T
        SET     ERR_FLG     =   'Y'
            ,   ERR_DESC    =   'Critical items is missing(AcclAmt, SLane, Node, ActDt, ActPlc, Vendor, Curr, Ofc, RevVVD, Acct)'
        WHERE   EXE_YRMON = pi_exeMonth
          AND   NVL(CXL_FLG, 'N') = 'N'
          AND   (
                        ACCL_COST_AMT   IS NULL
                    OR  SLAN_CD         IS NULL
                    OR  NOD_CD          IS NULL 
                    OR  ACT_DT          IS NULL 
                    OR  VNDR_NO         IS NULL 
                    OR  LOCL_CURR_CD    IS NULL  
                    OR  CTRL_OFC_CD     IS NULL  
                    OR  VSL_CD          IS NULL 
                    OR  SKD_VOY_NO      IS NULL 
                    OR  SKD_DIR_CD      IS NULL 
                    OR  REV_DIR_CD      IS NULL
                    OR  ACCT_CD         IS NULL
                )
        ;

        --Package Execution End Log Update...
        UPDATE  SAC_IF_ERR_LOG
        SET     ATTR_CTNT3 =    'END'
            ,   UPD_DT      =   SYSDATE
            ,   ATTR_CTNT5  =   FLOOR((SYSDATE-CRE_DT)*24) || '''' || FLOOR(MOD((SYSDATE-CRE_DT)*24,1)*60) || '''' || TRUNC(ROUND(MOD((SYSDATE-CRE_DT)*24*60,1)*60))
        WHERE   1 = 1
          AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'
          AND   SRC_MDL_CD  = 'ACCLTRS'
          AND   ERR_DESC    = 'EXEC_LOG'
          AND   EXE_YRMON   = pi_exeMonth
          AND   ATTR_CTNT1  = TO_CHAR(SYSDATE, 'YYYYMMDD')
          AND   ATTR_CTNT2  = R_EXEC_CNT
        ;
        COMMIT;
        
        po_result := 'S';

    EXCEPTION
        WHEN my_exception THEN
            ROLLBACK;
            
            IF ERRMSG IS NULL THEN
                ERRMSG := SQLERRM;
            END IF;
            
            SCO_ERR_LOG_PRC('SAC_TRS_TES_ACCRUAL_PKG.TRS_ACCRUAL_INSERT', ERRMSG, pi_exeMonth, 'ACCRUAL');

            --Package Execution End Log Update...
            UPDATE  SAC_IF_ERR_LOG
            SET     ATTR_CTNT3 =    'FAIL'
                ,   UPD_DT      =   SYSDATE
                ,   ATTR_CTNT5  =   FLOOR((SYSDATE-CRE_DT)*24) || '''' || FLOOR(MOD((SYSDATE-CRE_DT)*24,1)*60) || '''' || TRUNC(ROUND(MOD((SYSDATE-CRE_DT)*24*60,1)*60))
            WHERE   1 = 1
              AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'
              AND   SRC_MDL_CD  = 'ACCLTRS'
              AND   ERR_DESC    = 'EXEC_LOG'
              AND   EXE_YRMON   = pi_exeMonth
              AND   ATTR_CTNT1  = TO_CHAR(SYSDATE, 'YYYYMMDD')
              AND   ATTR_CTNT2  = R_EXEC_CNT
            ;
            COMMIT;

            po_result := 'E';

        WHEN OTHERS THEN
            ROLLBACK;
            
            IF ERRMSG IS NULL THEN
                ERRMSG := SQLERRM;
            END IF;
            
            SCO_ERR_LOG_PRC('SAC_TRS_TES_ACCRUAL_PKG.TRS_ACCRUAL_INSERT', ERRMSG, pi_exeMonth, 'ACCRUAL');

            --Package Execution End Log Update...
            UPDATE  SAC_IF_ERR_LOG
            SET     ATTR_CTNT3 =    'FAIL'
                ,   UPD_DT      =   SYSDATE
                ,   ATTR_CTNT5  =   FLOOR((SYSDATE-CRE_DT)*24) || '''' || FLOOR(MOD((SYSDATE-CRE_DT)*24,1)*60) || '''' || TRUNC(ROUND(MOD((SYSDATE-CRE_DT)*24*60,1)*60))
            WHERE   1 = 1
              AND   PGM_APPL_NM = 'SAC_TRS_TES_ACCRUAL_PKG'
              AND   SRC_MDL_CD  = 'ACCLTRS'
              AND   ERR_DESC    = 'EXEC_LOG'
              AND   EXE_YRMON   = pi_exeMonth
              AND   ATTR_CTNT1  = TO_CHAR(SYSDATE, 'YYYYMMDD')
              AND   ATTR_CTNT2  = R_EXEC_CNT
            ;
            COMMIT;

            po_result := 'E';

    END TRS_ACCRUAL_INSERT;
    
END SAC_TRS_TES_ACCRUAL_PKG;
/
