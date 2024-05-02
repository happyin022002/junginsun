/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeOfficeTransferMgtDBDAOAddOfficeTransferHistoryByPartialPaymentCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.09
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.07.09 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeOfficeTransferMgtDBDAOAddOfficeTransferHistoryByPartialPaymentCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Transfer된 Charge를 Partial 하는 경우, 새로 생성되는 Charge의 Office Transfer History 정보를 생성한다.
	  * </pre>
	  */
	public ChargeOfficeTransferMgtDBDAOAddOfficeTransferHistoryByPartialPaymentCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration").append("\n"); 
		query.append("FileName : ChargeOfficeTransferMgtDBDAOAddOfficeTransferHistoryByPartialPaymentCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_OFC_TRNS_HIS (" ).append("\n"); 
		query.append("FM_OFC_CD" ).append("\n"); 
		query.append(",	TO_OFC_CD" ).append("\n"); 
		query.append(",	TRNS_RSN" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_CYC_NO" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	CHG_SEQ" ).append("\n"); 
		query.append(",	OFC_TRNS_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("FM_OFC_CD" ).append("\n"); 
		query.append(",	TO_OFC_CD" ).append("\n"); 
		query.append(",	TRNS_RSN" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_CYC_NO" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	@[chg_seq]" ).append("\n"); 
		query.append(",	1" ).append("\n"); 
		query.append("FROM    DMT_OFC_TRNS_HIS" ).append("\n"); 
		query.append("WHERE	CNTR_NO					= @[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO				= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		DMDT_TRF_CD				= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_LOC_DIV_CD		= @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		CHG_SEQ					= @[org_chg_seq]" ).append("\n"); 
		query.append("AND     OFC_TRNS_SEQ            = (	SELECT MAX(OFC_TRNS_SEQ)" ).append("\n"); 
		query.append("FROM DMT_OFC_TRNS_HIS" ).append("\n"); 
		query.append("WHERE   CNTR_NO					= @[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO				= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		DMDT_TRF_CD				= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_LOC_DIV_CD		= @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		CHG_SEQ					= @[org_chg_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}