/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOUpdateSmpCtrtFcastCustAmendUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOUpdateSmpCtrtFcastCustAmendUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP Customer Amend S/C, RFA 정보를 Update 합니다.
	  * 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청 - Amend 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAOUpdateSmpCtrtFcastCustAmendUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOUpdateSmpCtrtFcastCustAmendUSQL").append("\n"); 
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
		query.append("UPDATE SPC_CTRT_FCAST_CUST C" ).append("\n"); 
		query.append("  SET" ).append("\n"); 
		query.append("#if (${pre_rfa_no} != '')" ).append("\n"); 
		query.append("      RFA_NO     = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pre_sc_no} != '')" ).append("\n"); 
		query.append("      SC_NO      = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("     ,UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE (C.RLANE_CD, C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD) IN ( SELECT V.RLANE_CD, V.VSL_CD, V.SKD_VOY_NO, V.DIR_CD" ).append("\n"); 
		query.append("                                                                FROM SPC_MDL_VER_MST M," ).append("\n"); 
		query.append("                                                                     MAS_MON_VVD     V" ).append("\n"); 
		query.append("                                                               WHERE M.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("                                                                 AND M.COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                                                                 AND M.VER_SEQ   = @[ver_seq]" ).append("\n"); 
		query.append("                                                                 AND M.TRD_CD    = V.TRD_CD" ).append("\n"); 
		query.append("                                                                 AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                                                 AND M.CFM_FLG   = 'Y'" ).append("\n"); 
		query.append("                                                                 AND V.DELT_FLG  = 'N' )" ).append("\n"); 
		query.append("  AND C.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("  AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND C.CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("#if (${pre_rfa_no} != '')" ).append("\n"); 
		query.append("  AND C.RFA_NO      = @[pre_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pre_sc_no} != '')" ).append("\n"); 
		query.append("  AND C.SC_NO       = @[pre_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
