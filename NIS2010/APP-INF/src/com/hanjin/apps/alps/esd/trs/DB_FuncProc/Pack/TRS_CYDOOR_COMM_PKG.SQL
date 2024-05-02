CREATE OR REPLACE PACKAGE TRS_CYDOOR_COMM_PKG
AUTHID CURRENT_USER
IS 

/******************************************************************************
   Name         :   GET_NODE_FNC
   Purpose      :   S/O 대상조회시 NODE, YARD를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_SO_NODE_FNC
(
    p_node_div IN VARCHAR2,
    p_pctl_io_bnd_cd IN VARCHAR2,
    p_pctl_cost_mod_cd IN VARCHAR2,
    p_n1st_nod_cd IN VARCHAR2,
    p_n2nd_nod_cd IN VARCHAR2,
    p_n3rd_nod_cd IN VARCHAR2,
    p_n4th_nod_cd IN VARCHAR2,
    p_nod_yard_div IN VARCHAR2
)
RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_BKG_VVD
   Purpose      :   S/O 대상조회시 VVD 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_BKG_VVD
(
    p_bnd        IN VARCHAR2,
    p_bkg_no     IN VARCHAR2,
    p_pod_pol    IN VARCHAR2
)

RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_TRSP_COST_DTL_MOD_SEP
   Purpose      :   S/O 대상조회시 TRSP_COST_DTL_MOD_CD를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_TRSP_COST_DTL_MOD_SEP
(
    p_trsp_cost_dtl_mod_cd  IN VARCHAR2,
    p_fn_nod_cd             IN VARCHAR2,
    p_to_nod_cd             IN VARCHAR2,
    p_trsp_bnd_cd           IN VARCHAR2
)

RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_SEPERATION
   Purpose      :   S/O 대상조회시 TRSP_COST_DTL_MOD_CD를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_SEPERATION
(
    p_prameter  IN VARCHAR2
)

RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_SEPERATION_VVD
   Purpose      :   S/O 대상조회시 TRSP_COST_DTL_MOD_CD를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_SEPERATION_VVD
(
    p_prameter  IN VARCHAR2
)
RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_SEAL_NO
   Purpose      :   S/O 대상조회시 SEAL NO 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_SEAL_NO
(
    p_bkg_no     IN VARCHAR2,
    p_cntr_no    IN VARCHAR2
)

RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_MULTI_LST_LOC
   Purpose      :   S/O 대상조회시 MULTI LST LOC 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_MULTI_LST_LOC
(
    p_org_loc_cd     IN VARCHAR2,
    p_dest_loc_cd    IN VARCHAR2
)

RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_CONTI_CD
   Purpose      :   S/O 대상조회시 CONTI_CD 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_CONTI_CD
(
    p_loc_cd     IN VARCHAR2
)

RETURN VARCHAR2;

/******************************************************************************
   Name         :   GET_TRO_MAPG
   Purpose      :   S/O 대상조회시 TRO_MAPG 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_TRO_MAPG
(
    p_cop_no     IN VARCHAR2,
    p_io_bnd_cd  IN VARCHAR2,
    p_conti_cd   IN VARCHAR2
)

RETURN VARCHAR2;


END TRS_CYDOOR_COMM_PKG;
/
CREATE OR REPLACE PACKAGE BODY TRS_CYDOOR_COMM_PKG IS 

/******************************************************************************
   Name         :   GET_NODE_FNC
   Purpose      :   S/O 대상조회시 NODE, YARD를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_SO_NODE_FNC
(
    p_node_div IN VARCHAR2,
    p_pctl_io_bnd_cd IN VARCHAR2,
    p_pctl_cost_mod_cd IN VARCHAR2,
    p_n1st_nod_cd IN VARCHAR2,
    p_n2nd_nod_cd IN VARCHAR2,
    p_n3rd_nod_cd IN VARCHAR2,
    p_n4th_nod_cd IN VARCHAR2,
    p_nod_yard_div IN VARCHAR2
)
RETURN VARCHAR2
IS
r_node VARCHAR2(7);
v_pctl_cost_mod_cd SCE_PLN_SO_LIST.PCTL_COST_MOD_CD%TYPE := NVL(p_pctl_cost_mod_cd, 'C');
BEGIN
    IF p_node_div = 'TO' THEN
        IF p_pctl_io_bnd_cd IN ('O','I','T') AND v_pctl_cost_mod_cd IN ('C', 'Z') AND p_n2nd_nod_cd IS NOT NULL THEN
            IF p_n3rd_nod_cd IS NULL THEN
                r_node := p_n2nd_nod_cd;
            ELSIF p_n4th_nod_cd IS NULL THEN
                r_node := p_n3rd_nod_cd;
            ELSIF p_n3rd_nod_cd IS NOT NULL AND p_n4th_nod_cd IS NOT NULL THEN
                r_node := p_n4th_nod_cd;
            ELSE
                r_node := '';
            END IF;
        END IF;

    ELSIF p_node_div = 'VIA' THEN
        IF v_pctl_cost_mod_cd = 'C' AND
           p_n1st_nod_cd IS NOT NULL AND p_n2nd_nod_cd IS NOT NULL AND
           p_n3rd_nod_cd IS NOT NULL AND p_n4th_nod_cd IS NULL THEN
            r_node := p_n2nd_nod_cd;
        ELSIF p_pctl_io_bnd_cd = 'I' AND v_pctl_cost_mod_cd = 'Z' AND 
           p_n1st_nod_cd IS NOT NULL AND p_n2nd_nod_cd IS NOT NULL AND 
           p_n3rd_nod_cd IS NOT NULL AND p_n4th_nod_cd IS NOT NULL THEN
            r_node := p_n2nd_nod_cd;
        ELSIF p_pctl_io_bnd_cd = 'O' AND v_pctl_cost_mod_cd = 'Z' AND 
           p_n1st_nod_cd IS NOT NULL AND p_n2nd_nod_cd IS NOT NULL AND 
           p_n3rd_nod_cd IS NOT NULL AND p_n4th_nod_cd IS NOT NULL THEN
            r_node := p_n3rd_nod_cd;
        ELSE
            r_node := '';
        END IF;
    ELSIF p_node_div = 'DOR' THEN
        IF p_pctl_io_bnd_cd = 'O' AND v_pctl_cost_mod_cd = 'Z' AND
           p_n1st_nod_cd IS NOT NULL AND p_n2nd_nod_cd IS NOT NULL AND
           p_n3rd_nod_cd IS NOT NULL AND p_n4th_nod_cd IS NULL THEN
            r_node := p_n2nd_nod_cd;
        ELSIF p_pctl_io_bnd_cd = 'O' AND v_pctl_cost_mod_cd = 'Z' AND
           p_n1st_nod_cd IS NOT NULL AND p_n2nd_nod_cd IS NOT NULL AND
           p_n3rd_nod_cd IS NOT NULL AND p_n4th_nod_cd IS NOT NULL THEN
            r_node := p_n2nd_nod_cd;
       ELSIF p_pctl_io_bnd_cd = 'I' AND v_pctl_cost_mod_cd = 'Z' AND
           p_n1st_nod_cd IS NOT NULL AND p_n2nd_nod_cd IS NOT NULL AND
           p_n3rd_nod_cd IS NOT NULL AND p_n4th_nod_cd IS NULL THEN
            r_node := p_n2nd_nod_cd;
       ELSIF p_pctl_io_bnd_cd = 'I' AND v_pctl_cost_mod_cd = 'Z' AND
           p_n1st_nod_cd IS NOT NULL AND p_n2nd_nod_cd IS NOT NULL AND
           p_n3rd_nod_cd IS NOT NULL AND p_n4th_nod_cd IS NOT NULL THEN
            r_node := p_n3rd_nod_cd;
       ELSE
            r_node := '';
       END IF;
    END IF;

    IF p_nod_yard_div = 'NODE' THEN
        r_node := SUBSTR(r_node, 1,5);
    ELSIF p_nod_yard_div = 'YARD' THEN
        r_node := SUBSTR(r_node, 6);
    END IF;

	RETURN r_node;
END ;

/******************************************************************************
   Name         :   GET_BKG_VVD
   Purpose      :   S/O 대상조회시 VVD 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_BKG_VVD(
    p_bnd        IN VARCHAR2,
    p_bkg_no     IN VARCHAR2,
    p_pod_pol    IN VARCHAR2
) RETURN VARCHAR2
IS
r_data VARCHAR2(100);
BEGIN
    BEGIN
        IF p_bnd = 'I' THEN
            BEGIN
            SELECT NVL(IB.VSL_CD||IB.SKD_VOY_NO||IB.SKD_DIR_CD, ' ')
              INTO r_data
              FROM BKG_VVD IB
             WHERE IB.BKG_NO = p_bkg_no
               AND IB.POD_CD = p_pod_pol
               --AND IB.VSL_PRE_PST_CD <> 'T'
               AND ROWNUM = 1;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    r_data := '';
            END;
        ELSIF p_bnd = 'O' THEN
            BEGIN
            SELECT NVL(OB.VSL_CD||OB.SKD_VOY_NO||OB.SKD_DIR_CD, ' ')
              INTO r_data
              FROM BKG_VVD OB
             WHERE OB.BKG_NO = p_bkg_no
               AND OB.POL_CD = p_pod_pol
               --AND OB.VSL_PRE_PST_CD <> 'T'
               AND ROWNUM = 1; 
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    r_data := '';
            END;
        ELSIF p_bnd = 'A' THEN
            BEGIN
            SELECT FVVD 
              INTO r_data
              FROM (
                SELECT NVL(IB.VSL_CD||IB.SKD_VOY_NO||IB.SKD_DIR_CD, ' ') FVVD
                  FROM BKG_VVD IB
                 WHERE IB.BKG_NO = p_bkg_no
                   AND IB.POD_CD = p_pod_pol
                   --AND IB.VSL_PRE_PST_CD <> 'T'
                UNION
                SELECT NVL(OB.VSL_CD||OB.SKD_VOY_NO||OB.SKD_DIR_CD, ' ')
                  FROM BKG_VVD OB
                 WHERE OB.BKG_NO = p_bkg_no
                   AND OB.POL_CD = p_pod_pol
                   --AND OB.VSL_PRE_PST_CD <> 'T'
            )
            WHERE ROWNUM = 1;
            EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    r_data := '';
            END;
        END IF;
        
        IF r_data IS NULL THEN
            r_data := ' ';
        END IF;
        
        RETURN r_data;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            r_data := '';
        WHEN OTHERS THEN
            RAISE_APPLICATION_ERROR(-20001, 'GET_BKG_VVD : '+ p_bkg_no + ' ' + p_pod_pol);
    END;
END;

/******************************************************************************
   Name         :   GET_TRSP_COST_DTL_MOD_SEP
   Purpose      :   S/O 대상조회시 TRSP_COST_DTL_MOD_CD를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_TRSP_COST_DTL_MOD_SEP(
    p_trsp_cost_dtl_mod_cd  IN VARCHAR2,
    p_fn_nod_cd             IN VARCHAR2,
    p_to_nod_cd             IN VARCHAR2,
    p_trsp_bnd_cd           IN VARCHAR2
) RETURN VARCHAR2
IS
r_data     VARCHAR2(4000);
BEGIN
    SELECT CASE WHEN p_trsp_cost_dtl_mod_cd = 'CY' THEN
                CASE WHEN p_fn_nod_cd = p_to_nod_cd THEN
                     CASE WHEN p_trsp_bnd_cd = 'T' OR p_trsp_bnd_cd = 'P' THEN 'TS'
                          WHEN p_trsp_bnd_cd = 'I' OR p_trsp_bnd_cd = 'O' THEN 'LS'
                          ELSE ''
                     END
                     ELSE 'CY'
                END
                WHEN p_trsp_cost_dtl_mod_cd = 'DOOR' THEN 'DR'
                ELSE
                CASE WHEN p_fn_nod_cd = p_to_nod_cd THEN
                     CASE WHEN p_trsp_bnd_cd = 'T' OR p_trsp_bnd_cd = 'P' THEN 'TS'
                          WHEN p_trsp_bnd_cd = 'I' OR p_trsp_bnd_cd = 'O' THEN 'LS'
                          ELSE ''
                     END
                      ELSE 'NO'
                END
           END
     INTO r_data
     FROM DUAL;
    RETURN r_data;
END;

/******************************************************************************
   Name         :   GET_SEPERATION
   Purpose      :   S/O 대상조회시 TRSP_COST_DTL_MOD_CD를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_SEPERATION(
    p_prameter  IN VARCHAR2
) RETURN VARCHAR2
IS
r_data     VARCHAR2(4000);
BEGIN
    
    SELECT '''' || REPLACE(p_prameter, ',' , ''',''') || ''''
     INTO r_data
     FROM DUAL;
    RETURN r_data;
END;

/******************************************************************************
   Name         :   GET_SEPERATION_VVD
   Purpose      :   S/O 대상조회시 TRSP_COST_DTL_MOD_CD를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_SEPERATION_VVD(
    p_prameter  IN VARCHAR2
) RETURN VARCHAR2
IS

v_cnt      NUMBER(3) := 0;
v_prameter VARCHAR2(1000);
v_vvd      VARCHAR2(1000);
v_remain   VARCHAR2(1000);
v_remain2   VARCHAR2(1000);
r_data     VARCHAR2(1000);
BEGIN

    -- FOR문 안에서 INSTR 함수가 정상적으로 작동하지 않는 경우 발생하여 자리수로만 체크.
    v_cnt := LENGTH(REPLACE(REPLACE(p_prameter, ',' , ''), ' ', ''))/9 ;
    v_remain := p_prameter;
    IF v_cnt > 0 THEN 
        FOR i IN 1..v_cnt LOOP
            v_vvd := SUBSTR(v_remain,1,9);
            v_vvd := '('''||substr(v_vvd,1,4) ||''','''|| substr(v_vvd,5,4) ||''','''|| substr(v_vvd,9)||''')';
            IF i = v_cnt THEN
                v_vvd := v_vvd;
            ELSE
                v_vvd := v_vvd || ',';
            END IF;
            v_remain := SUBSTR(REPLACE(REPLACE(v_remain, ',' , ''), ' ', ''),10);
    
            v_prameter := v_prameter ||v_vvd;
        END LOOP;
    END IF;
    
    RETURN v_prameter;
    
END;

/******************************************************************************
   Name         :   GET_SEAL_NO
   Purpose      :   S/O 대상조회시 SEAL NO 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_SEAL_NO(
    p_bkg_no     IN VARCHAR2,
    p_cntr_no    IN VARCHAR2
) RETURN VARCHAR2
IS
r_data     VARCHAR2(500);
BEGIN
    BEGIN
        FOR RET_DATA IN (SELECT CNTR_SEAL_NO
                           FROM BKG_CNTR_SEAL_NO 
                          WHERE BKG_NO  = p_bkg_no
                            AND CNTR_NO = p_cntr_no
                        )
        LOOP
            r_data := r_data ||', '|| RET_DATA.CNTR_SEAL_NO;
        END LOOP;
        r_data := SUBSTR(r_data,2);
    
        RETURN r_data;
    EXCEPTION
        WHEN OTHERS THEN
            RAISE_APPLICATION_ERROR(-20001, 'GET_SEAL_NO');
    END;
END;

/******************************************************************************
   Name         :   GET_MULTI_LST_LOC
   Purpose      :   S/O 대상조회시 MULTI LST LOC 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_MULTI_LST_LOC(
    p_org_loc_cd     IN VARCHAR2,
    p_dest_loc_cd    IN VARCHAR2
) RETURN VARCHAR2
IS
r_data     VARCHAR2(500);
BEGIN
    BEGIN
        FOR RET_DATA IN (SELECT LST_LOC_CD
                           FROM TRS_DMST_LST_CTY 
                          WHERE ORG_LOC_CD  = p_org_loc_cd
                            AND DEST_LOC_CD = p_dest_loc_cd
                            AND DELT_FLG    = 'N'
                        )
        LOOP
            r_data := r_data ||', '|| RET_DATA.LST_LOC_CD;
        END LOOP;
        r_data := SUBSTR(r_data,2);
    
        RETURN r_data;
    EXCEPTION
        WHEN OTHERS THEN
            RAISE_APPLICATION_ERROR(-20001, 'GET_MULTI_LST_LOC');
    END;
END;

/******************************************************************************
   Name         :   GET_CONTI_CD
   Purpose      :   S/O 대상조회시 CONTI_CD 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_CONTI_CD(
    p_loc_cd     IN VARCHAR2
) RETURN VARCHAR2
IS
r_data     VARCHAR2(500);
BEGIN
    BEGIN
        SELECT CONTI_CD 
          INTO r_data
          FROM MDM_LOCATION PD 
         WHERE PD.LOC_CD = p_loc_cd;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            r_data := '';
        WHEN OTHERS THEN
            RAISE_APPLICATION_ERROR(-20001, 'GET_CONTI_CD');
    END;
    RETURN r_data;
END;

/******************************************************************************
   Name         :   GET_TRO_MAPG
   Purpose      :   S/O 대상조회시 CONTI_CD 정보를 구하는 Function
   Table        :   
   Ver          :   1.0
   Date         :   2009.08.14
******************************************************************************/
FUNCTION GET_TRO_MAPG(
    p_cop_no     IN VARCHAR2,
    p_io_bnd_cd  IN VARCHAR2,
    p_conti_cd   IN VARCHAR2
) RETURN VARCHAR2
IS
r_data     VARCHAR2(500);
BEGIN
    BEGIN
        SELECT TO_CHAR(MAPG.TRO_SEQ)||'$'||TO_CHAR(MAPG.TRO_SUB_SEQ)
          INTO r_data
          FROM SCE_TRO_MAPG MAPG
         WHERE MAPG.COP_NO    = p_cop_no
           AND MAPG.IO_BND_CD = p_io_bnd_cd
           AND MAPG.AREA_CONTI_CD = DECODE(p_conti_cd, 'E', 'E', 'X');
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            r_data := '';
        WHEN OTHERS THEN
            RAISE_APPLICATION_ERROR(-20001, 'GET_TRO_MAPG '||p_cop_no||' '||p_io_bnd_cd||' '||p_conti_cd);
    END;
    RETURN r_data;
END;

END TRS_CYDOOR_COMM_PKG;
