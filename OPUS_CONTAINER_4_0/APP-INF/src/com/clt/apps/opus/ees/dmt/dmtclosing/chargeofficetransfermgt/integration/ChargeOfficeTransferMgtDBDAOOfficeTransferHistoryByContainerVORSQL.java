/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeOfficeTransferMgtDBDAOOfficeTransferHistoryByContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.01.04 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeOfficeTransferMgtDBDAOOfficeTransferHistoryByContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeOfficeTransferMgtDBDAOOfficeTransferHistoryByContainerVORSQL(){
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.integration").append("\n"); 
		query.append("FileName : ChargeOfficeTransferMgtDBDAOOfficeTransferHistoryByContainerVORSQL").append("\n"); 
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
		query.append("SELECT	 FM_OFC_CD" ).append("\n"); 
		query.append(",TO_OFC_CD" ).append("\n"); 
		query.append(",TRNS_RSN" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",USR_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT	DISTINCT" ).append("\n"); 
		query.append("OT.FM_OFC_CD" ).append("\n"); 
		query.append(",OT.TO_OFC_CD" ).append("\n"); 
		query.append(",OT.TRNS_RSN" ).append("\n"); 
		query.append(",TO_CHAR(OT.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append(",OT.CRE_OFC_CD" ).append("\n"); 
		query.append(",(	SELECT CU.USR_NM" ).append("\n"); 
		query.append("FROM COM_USER CU" ).append("\n"); 
		query.append("WHERE CU.USR_ID = OT.CRE_USR_ID" ).append("\n"); 
		query.append(") AS USR_NM" ).append("\n"); 
		query.append("FROM	DMT_OFC_TRNS_HIS OT" ).append("\n"); 
		query.append("WHERE	OT.CNTR_NO				= @[cntr_no]" ).append("\n"); 
		query.append("AND     OT.CNTR_CYC_NO			= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     OT.DMDT_TRF_CD			= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     OT.DMDT_CHG_LOC_DIV_CD	= @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     OT.CHG_SEQ				= @[chg_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CRE_DT" ).append("\n"); 

	}
}