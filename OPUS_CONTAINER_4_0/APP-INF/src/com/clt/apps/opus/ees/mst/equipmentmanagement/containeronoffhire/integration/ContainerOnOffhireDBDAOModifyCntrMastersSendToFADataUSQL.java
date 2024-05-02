/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMastersSendToFADataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMastersSendToFADataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMastersSendToFAData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMastersSendToFADataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fa_if_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_invst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_qty_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lot_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_cng_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_aqz_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMastersSendToFADataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER" ).append("\n"); 
		query.append("SET CNTR_CURR_CD = @[cntr_curr_cd]," ).append("\n"); 
		query.append("    CNTR_AQZ_AMT = @[cntr_aqz_amt]," ).append("\n"); 
		query.append("    CNTR_INVST_NO = @[cntr_invst_no]," ).append("\n"); 
		query.append("    ACCT_QTY_MZD_CD = @[acct_qty_mzd_cd]," ).append("\n"); 
		query.append("    FA_IF_TP_CD = '1'," ).append("\n"); 
		query.append("    FA_IF_STS_CD = 'S'," ).append("\n"); 
		query.append("	FA_IF_GRP_STS_CD = 'S'," ).append("\n"); 
		query.append("    FA_IF_DT = SYSDATE, " ).append("\n"); 
		query.append("#if (${hid_type} == '1') " ).append("\n"); 
		query.append("	FA_EQ_NO = DECODE(FA_EQ_NO, NULL, CNTR_NO, FA_EQ_NO)," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE," ).append("\n"); 
		query.append("    IF_SEQ = ROWNUM," ).append("\n"); 
		query.append("    FA_IF_GRP_SEQ_NO = @[fa_if_grp_seq]," ).append("\n"); 
		query.append("    EAI_IF_NO = 'FNS026_0001_MST_'||TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISSSSS')," ).append("\n"); 
		query.append("    IF_TTL_ROW_KNT = @[cntr_qty]" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${hid_type} == '0') " ).append("\n"); 
		query.append("AND LOT_PLN_YR    = @[lot_pln_yr]" ).append("\n"); 
		query.append("AND LOT_LOC_CD    = @[lot_loc_cd]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD  = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND LOT_SEQ       = @[lot_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hid_type} == '1') " ).append("\n"); 
		query.append("AND TERM_CNG_SEQ = @[term_cng_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}