/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOmodifyBkgCntrPkcMeasWgtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.16 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOmodifyBkgCntrPkcMeasWgtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgCntrPkcMeasWgt
	  * </pre>
	  */
	public BLDocumentationCMDBDAOmodifyBkgCntrPkcMeasWgtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOmodifyBkgCntrPkcMeasWgtUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER SET" ).append("\n"); 
		query.append("PCK_QTY = (SELECT SUM(PCK_QTY) FROM BKG_CONTAINER WHERE (BKG_NO = @[mst_bkg_no] OR BKG_NO = @[bkg_no]) AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(", MEAS_QTY = (SELECT SUM(MEAS_QTY) FROM BKG_CONTAINER WHERE (BKG_NO = @[mst_bkg_no] OR BKG_NO = @[bkg_no]) AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(", CNTR_WGT = (SELECT SUM(CNTR_WGT) FROM BKG_CONTAINER WHERE (BKG_NO = @[mst_bkg_no] OR BKG_NO = @[bkg_no]) AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(", CNTR_VOL_QTY = (SELECT SUM(CNTR_VOL_QTY) FROM BKG_CONTAINER WHERE (BKG_NO = @[mst_bkg_no] OR BKG_NO = @[bkg_no]) AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(", CNTR_PRT_FLG = CASE WHEN (SELECT SUM(CNTR_VOL_QTY)" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE (BKG_NO = @[mst_bkg_no] OR BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]) = 1 THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append(", UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[mst_bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}