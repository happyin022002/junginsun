/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLDocumentationCMDBDAOmodifyCntrPorPolUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOmodifyCntrPorPolUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCntrPorPol
	  * </pre>
	  */
	public BLDocumentationCMDBDAOmodifyCntrPorPolUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combine_bkg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mst_bkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOmodifyCntrPorPolUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("SET CNTR.POR_NOD_CD = (SELECT POR_NOD_CD FROM BKG_BOOKING WHERE BKG_NO = CASE (SELECT COUNT(1)" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CMB" ).append("\n"); 
		query.append("WHERE CNTR.CNTR_NO = CMB.CNTR_NO" ).append("\n"); 
		query.append("AND CMB.BKG_NO = @[combine_bkg]) WHEN 0 THEN @[mst_bkg] ELSE @[combine_bkg] END)" ).append("\n"); 
		query.append(",CNTR.POL_YD_CD = (SELECT POL_NOD_CD FROM BKG_BOOKING WHERE BKG_NO = CASE (SELECT COUNT(1)" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CMB" ).append("\n"); 
		query.append("WHERE CNTR.CNTR_NO = CMB.CNTR_NO" ).append("\n"); 
		query.append("AND CMB.BKG_NO = @[combine_bkg]) WHEN 0 THEN @[mst_bkg] ELSE @[combine_bkg] END)" ).append("\n"); 
		query.append(",CNTR.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",CNTR.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO = @[mst_bkg]" ).append("\n"); 

	}
}