/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOInsertVnorItemCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOInsertVnorItemCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNOR 의 Item을 생성합니다.
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOInsertVnorItemCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_mn_itm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOInsertVnorItemCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_VNOR_ITM (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append("	,VNOR_SEQ" ).append("\n"); 
		query.append("	,VNOR_ITM_SEQ" ).append("\n"); 
		query.append("	,VNOR_MN_ITM_FLG" ).append("\n"); 
		query.append("	,VNOR_ITM_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_OFC_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_UT_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_VAL" ).append("\n"); 
		query.append("	,VNOR_ITM_STS_CD" ).append("\n"); 
		query.append("	,VNOR_ITM_RMK" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	@[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("	,@[vnor_seq] AS VNOR_SEQ" ).append("\n"); 
		query.append("	,OPF_VNOR_ITM_SEQ.NEXTVAL AS VNOR_ITM_SEQ" ).append("\n"); 
		query.append("	,@[vnor_mn_itm_flg] AS VNOR_MN_ITM_FLG" ).append("\n"); 
		query.append("	,@[vnor_itm_cd] AS VNOR_ITM_CD" ).append("\n"); 
		query.append("	,@[vnor_itm_ofc_cd] AS VNOR_ITM_OFC_CD" ).append("\n"); 
		query.append("	,@[vnor_itm_ut_cd] AS VNOR_ITM_UT_CD" ).append("\n"); 
		query.append("	,@[vnor_itm_val] AS VNOR_ITM_VAL" ).append("\n"); 
		query.append("	,@[vnor_itm_sts_cd] AS VNOR_ITM_STS_CD" ).append("\n"); 
		query.append("	,@[vnor_itm_rmk] AS VNOR_ITM_RMK" ).append("\n"); 
		query.append("	,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("	,@[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 

	}
}