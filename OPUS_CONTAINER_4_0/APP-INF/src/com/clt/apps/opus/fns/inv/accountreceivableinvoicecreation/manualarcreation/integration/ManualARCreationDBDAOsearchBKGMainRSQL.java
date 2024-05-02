/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchBKGMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.23 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchBKGMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBKGMain
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchBKGMainRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  BKG.BKG_NO," ).append("\n"); 
		query.append("BKG.BL_NO BL_SRC_NO," ).append("\n"); 
		query.append("BKG.VSL_CD||BKG.SKD_VOY_NO||DECODE(BKG.REV_DIR_CD, NULL, BKG.SKD_DIR_CD, ' ',  BKG.SKD_DIR_CD, BKG.REV_DIR_CD) Trunk_VVD," ).append("\n"); 
		query.append("BKG.POR_CD," ).append("\n"); 
		query.append("BKG.POL_CD," ).append("\n"); 
		query.append("BKG.POD_CD," ).append("\n"); 
		query.append("BKG.DEL_CD," ).append("\n"); 
		query.append("BKG.SVC_SCP_CD," ).append("\n"); 
		query.append("DECODE(BL.BL_CVRD_TP_CD, 'C', BL.MST_CVRD_BL_NO, BKG.BL_NO) Master_INV" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BKG, BKG_BL_DOC BL" ).append("\n"); 
		query.append("WHERE  BKG.BKG_NO =  BL.BKG_NO" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND    BKG.BL_NO = DECODE(@[bl_no], NULL, BKG.BL_NO, @[bl_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = DECODE(@[bkg_no], NULL, BKG.BKG_NO, @[bkg_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchBKGMainRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}