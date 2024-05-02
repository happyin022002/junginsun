/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchReminderEmailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchReminderEmailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Si, AES/CAED reminder의 정보를 조회한다
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchReminderEmailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchReminderEmailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("     WHERE DELT_FLG ='N'" ).append("\n"); 
		query.append("     AND VSL.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("     AND ROWNUM = 1 )||' '||BK.SKD_VOY_NO||BK.SKD_DIR_CD VSL_NM," ).append("\n"); 
		query.append("     BK.BL_NO BL_NO," ).append("\n"); 
		query.append("     SUBSTR(BK.POL_CD,1,2) CNT_CD," ).append("\n"); 
		query.append("     TO_CHAR(NVL(CLZ.MNL_SET_DT,CLZ.SYS_SET_DT),'MM/DD') DOC_CLZ_DT," ).append("\n"); 
		query.append("     TO_CHAR(NVL(CLZ.MNL_SET_DT,CLZ.SYS_SET_DT),'HH24:MI') DOC_CLZ_TM," ).append("\n"); 
		query.append("     TO_CHAR(VVD.VPS_ETD_DT,'MM/DD/YYYY') ETD_DT," ).append("\n"); 
		query.append("     TO_CHAR(VVD.VPS_ETA_DT,'MM/DD') ETA_DT," ).append("\n"); 
		query.append("     TO_CHAR(VVD.VPS_ETA_DT,'HH24:MI') ETA_TM" ).append("\n"); 
		query.append(" FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("     ,BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("     ,(SELECT VVD.BKG_NO,VSK.VPS_ETA_DT VPS_ETA_DT ,VSK.VPS_ETD_DT VPS_ETD_DT, VSK.SLAN_CD SLAN_CD, VSK.YD_CD YD_CD,VSK.SKD_DIR_CD SKD_DIR_CD  " ).append("\n"); 
		query.append("         FROM BKG_VVD VVD, VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("         AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("         AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("         AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("         AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = VVD.BKG_NO)) VVD         " ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = CLZ.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'D' = CLZ.CLZ_TP_CD(+)" ).append("\n"); 

	}
}