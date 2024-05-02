CREATE OR REPLACE FUNCTION SCE_REP_PCTL_NO_FNC ( v_bkg_no VARCHAR2, v_cntr_tpsz_cd VARCHAR2 )

/*******************************************************************************
   1. Object Name      : SCE_REP_PCTL_NO_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.09.16
   4. Sub System       : SCE
   5. Author           : ���μ�
   6. Description      : COP ���� ���� ���ǰ� ������ PC No �� return �Ѵ�.
                        1) s/o ���� ����
                        2) tro ���� ����
                        3) �ܼ� count
   7. Revision History : 2009.09.15 ���μ� ���� ����
                         2009.10.26 COP Header �� Bkg_no, Cntr_tpsz_cd �� match �Ǵ� 
                                    cop �� ���� ��� ���� ���� ���� COP �� ��ȸ�ϴ� ���� ����
                         2010.04.30 Memo Split�� ����ŷ �ϰ�� COP_STS_CD = X�� ������
*******************************************************************************/

RETURN VARCHAR2
authid current_user 
IS
    rep_pctl_no VARCHAR2(20);
    v_max_cnt NUMBER := 0;
    
    v_cop_no VARCHAR2(14);
    v_pctl_no VARCHAR2(20);
    v_ob_tro_flg VARCHAR2(1);
    v_ib_tro_flg VARCHAR2(1);
    
    v_tmp_pctl_no VARCHAR2(20);
    v_so_cnt NUMBER;
    
    v_rowCnt NUMBER := 0;
    v_memo_split_cnt NUMBER := 0;
    
CURSOR FIND_SO_STS IS
    select pctl_no,
      max(nvl(cnt, 0)) as cnt
    from (
        select a.pctl_no,
          count(*) as cnt
        from sce_cop_hdr a,
          sce_pln_so_list b 
        where a.cop_no = b.cop_no 
          and a.bkg_no = v_bkg_no
          and a.cntr_tpsz_cd = v_cntr_tpsz_cd
          and a.cop_sts_cd not in ('X',
              'O',
              'M')
          and b.trsp_so_sts_cd in ('C','I', 'R','X')  
        group by a.pctl_no )
    group by pctl_no;    

BEGIN

DBMS_OUTPUT.ENABLE;
--DBMS_OUTPUT.DISABLE;

--1) s/o ���� ����
OPEN FIND_SO_STS;
FETCH FIND_SO_STS INTO v_tmp_pctl_no, v_so_cnt;

IF FIND_SO_STS%FOUND THEN    
    rep_pctl_no := v_tmp_pctl_no;

    dbms_output.put_line('so found / v_tmp_pctl_no = ' || v_tmp_pctl_no);

ELSE
-- 2) tro ���� ����
    dbms_output.put_line('so not found');

    FOR V_SEARCH_TRO IN (
        select cop_no, pctl_no, NVL(ob_tro_flg, 'N') as ob_tro_flg, NVL(ib_tro_flg, 'N') as ib_tro_flg
        from sce_cop_hdr
         where bkg_no = v_bkg_no and cntr_tpsz_cd = v_cntr_tpsz_cd
         and cop_sts_cd not in ('X', 'M', 'O')
    )
        
    LOOP
        v_cop_no := V_SEARCH_TRO.cop_no;
        v_pctl_no := V_SEARCH_TRO.pctl_no;
        v_ob_tro_flg := V_SEARCH_TRO.ob_tro_flg;
        v_ib_tro_flg := V_SEARCH_TRO.ib_tro_flg;
        
        v_rowCnt := v_rowCnt + 1;
     
        IF (v_ob_tro_flg = 'Y' OR v_ib_tro_flg = 'Y') THEN
            rep_pctl_no := v_pctl_no;
        END IF;
               
        EXIT WHEN (v_ob_tro_flg = 'Y' OR v_ib_tro_flg = 'Y');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('NOT FOUND IN SEARCH TRO');
--3) �ܼ� count    
    IF ((v_ob_tro_flg = 'N' AND v_ib_tro_flg = 'N') OR v_rowCnt = 0) THEN
        IF (v_rowCnt = 0) THEN
            dbms_output.put_line('cop header not found!');
        ELSE
            dbms_output.put_line('tro not found so manual count!');
        END IF;
        
                -- Memo Split�� ����ŷ���� Ȯ�� 
        select count(*)
        into   v_memo_split_cnt
        from bkg_booking
        where 1=1
          and fm_bkg_no = v_bkg_no --'AARY1140001'
          and nvl(bl_no_tp,'0') <> '0'
        ;
        
        
        select pctl_no into rep_pctl_no from (
            select pctl_no,
              max(cnt) as cnt
            from (
                select pctl_no,
                  count(*) as cnt 
                from sce_cop_hdr
                where bkg_no = v_bkg_no
                    and   (v_memo_split_cnt = 0 and cop_sts_cd   not in ('X','M','O') -- �Ϲ� BKG �ϰ��
                     or  v_memo_split_cnt > 0 and cop_sts_cd   not in ('M','O')     -- Memo split�� ����ŷ �ϰ��
                         )
            --      and cntr_tpsz_cd = v_cntr_tpsz_cd
                  
                    group by pctl_no)
                group by pctl_no
                order by cnt
          ) 
          where rownum =1;
       
    END IF;
END IF;



CLOSE FIND_SO_STS;

RETURN rep_pctl_no;

END SCE_REP_PCTL_NO_FNC;
/
