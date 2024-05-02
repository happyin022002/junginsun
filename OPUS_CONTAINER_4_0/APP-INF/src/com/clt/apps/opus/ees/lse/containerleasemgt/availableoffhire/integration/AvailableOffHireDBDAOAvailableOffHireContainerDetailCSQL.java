/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireContainerDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.26
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2014.02.26 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireContainerDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선정된 대상장비의 내역을 반납가능 자료로 생성합니다.
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireContainerDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_hire_due_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("used_days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rem_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_hire_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireContainerDetailCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("MERGE INTO LSE_AVAL_OFFH T" ).append("\n"); 
		query.append("USING   (" ).append("\n"); 
		query.append("        SELECT   'X'  AS AGMT_CTY_CD" ).append("\n"); 
		query.append("                , 0   AS AGMT_SEQ" ).append("\n"); 
		query.append("                , 0   AS OFFH_SEQ" ).append("\n"); 
		query.append("                ,'X'  AS CNTR_NO" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  AGMT_CTY_CD, AGMT_SEQ, OFFH_SEQ, CNTR_NO" ).append("\n"); 
		query.append("        FROM    LSE_AVAL_OFFH" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     AGMT_CTY_CD     = @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND     AGMT_SEQ        = @[agmt_seq]" ).append("\n"); 
		query.append("        AND     CNTR_NO         = @[cntr_no]" ).append("\n"); 
		query.append("        AND     OFFH_STS_CD     = 'R'" ).append("\n"); 
		query.append("        ) S" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(           T.AGMT_CTY_CD  = S.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND     T.AGMT_SEQ     = S.AGMT_SEQ" ).append("\n"); 
		query.append("    AND     T.OFFH_SEQ     = S.OFFH_SEQ" ).append("\n"); 
		query.append("    AND     T.CNTR_NO      = S.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("-- 동일 장비에 2번 Request를 방지하기 위해 과거 Requst 정보를 'E' (에러) 로 변경." ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("        OFFH_STS_CD         = 'E'" ).append("\n"); 
		query.append("      , UPD_USR_ID          = @[cre_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT              = SYSDATE" ).append("\n"); 
		query.append("WHERE   T.AGMT_CTY_CD  = S.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     T.AGMT_SEQ     = S.AGMT_SEQ" ).append("\n"); 
		query.append("AND     T.OFFH_SEQ     = S.OFFH_SEQ" ).append("\n"); 
		query.append("AND     T.CNTR_NO      = S.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("-- 신규  데이터 생성." ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("       AGMT_CTY_CD" ).append("\n"); 
		query.append("       , AGMT_SEQ" ).append("\n"); 
		query.append("       , OFFH_SEQ" ).append("\n"); 
		query.append("       , CNTR_NO" ).append("\n"); 
		query.append("       , OFFH_YD_CD                                                     -- 05" ).append("\n"); 
		query.append("       , OFFH_DUE_DT" ).append("\n"); 
		query.append("       , VNDR_SEQ" ).append("\n"); 
		query.append("       , LSTM_CD" ).append("\n"); 
		query.append("       , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , RMN_QTY                                                        -- 10" ).append("\n"); 
		query.append("       , CNTR_FULL_FLG" ).append("\n"); 
		query.append("       , MVMT_STS_CD" ).append("\n"); 
		query.append("       , ONH_DT" ).append("\n"); 
		query.append("       , USD_DYS" ).append("\n"); 
		query.append("       , MNR_COST_AMT                                                   -- 15" ).append("\n"); 
		query.append("       , MTY_RTN_YD_CD" ).append("\n"); 
		query.append("       , LSE_CO_RTN_YD_CD" ).append("\n"); 
		query.append("       , OFFH_STS_CD" ).append("\n"); 
		query.append("       , LSE_CO_RTN_FLG" ).append("\n"); 
		query.append("       , RQST_OFC_CD                                                    -- 20" ).append("\n"); 
		query.append("       , CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, SND_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        @[agmt_cty_cd]" ).append("\n"); 
		query.append("      , @[agmt_seq]" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("        SELECT  NVL(MAX(OFFH_SEQ), 0) + 1" ).append("\n"); 
		query.append("        FROM    LSE_AVAL_OFFH" ).append("\n"); 
		query.append("        WHERE   AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND     AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("      , @[cntr_no]" ).append("\n"); 
		query.append("      , @[off_hire_yard]                                                 -- 05" ).append("\n"); 
		query.append("      , @[off_hire_due_date]" ).append("\n"); 
		query.append("      , @[vndr_seq]" ).append("\n"); 
		query.append("      , @[lstm_cd]" ).append("\n"); 
		query.append("      , @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("      , @[rem_qty]                                                       -- 10" ).append("\n"); 
		query.append("      , DECODE(@[full_flg],'F','Y','N')" ).append("\n"); 
		query.append("      , @[mvmt_sts_cd]" ).append("\n"); 
		query.append("      , TO_DATE(@[onh_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("      , @[used_days]" ).append("\n"); 
		query.append("      , @[mnr_cost]                                                      -- 15" ).append("\n"); 
		query.append("      , @[mty_rtn_yd_cd]" ).append("\n"); 
		query.append("      , ''" ).append("\n"); 
		query.append("      , 'R'" ).append("\n"); 
		query.append("      , 'N'" ).append("\n"); 
		query.append("      , (SELECT LST_LGIN_OFC_CD FROM COM_USER WHERE USR_ID = @[cre_usr_id])-- 20" ).append("\n"); 
		query.append("      , @[cre_usr_id], SYSDATE, @[cre_usr_id], SYSDATE, @[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}