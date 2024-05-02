/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchMigInterfaceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.03.20 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchMigInterfaceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchMigInterfaceListRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchMigInterfaceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchMigInterfaceListRSQL").append("\n"); 
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
		query.append("SELECT MN.AR_OFC_CD," ).append("\n"); 
		query.append("       MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.VSL_CD||MN.SKD_VOY_NO||MN.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       MN.SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.SLAN_CD," ).append("\n"); 
		query.append("       MN.POL_CD," ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.REV_VSL_CD||MN.REV_SKD_VOY_NO||MN.REV_SKD_DIR_CD||MN.REV_DIR_CD REV_VVD_CD," ).append("\n"); 
		query.append("       MN.RLANE_CD," ).append("\n"); 
		query.append("       MN.INV_DELT_DIV_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       MN.BKG_NO," ).append("\n"); 
		query.append("       SUBSTR(ORG.LOC_CD, 1, 2) LOC_CD," ).append("\n"); 
		query.append("       MN.IO_BND_CD," ).append("\n"); 
		query.append("       '' CREATE_FLAG," ).append("\n"); 
		query.append("       MN.BKG_TEU_QTY," ).append("\n"); 
		query.append("       MN.BKG_FEU_QTY," ).append("\n"); 
		query.append("       MN.BL_INV_IF_DT" ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append(" WHERE MN.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = ORG.OFC_CD" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N')<> 'Y'" ).append("\n"); 
		query.append("   AND MN.REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("   AND MN.OLD_AR_IF_NO IS NOT NULL" ).append("\n"); 
		query.append(" ORDER BY MN.AR_IF_NO" ).append("\n"); 

	}
}