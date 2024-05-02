/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchBkgQtyByCntrtsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.10 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchBkgQtyByCntrtsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgQtyByCntrts
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchBkgQtyByCntrtsRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchBkgQtyByCntrtsRSQL").append("\n"); 
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
		query.append("NVL((SELECT	SUM(NVL(OP_CNTR_QTY,0))" ).append("\n"); 
		query.append("FROM	BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	SUBSTR(CNTR_TPSZ_CD,2,1) = '2'" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD != 'Q4'),0) IN_TEU," ).append("\n"); 
		query.append("NVL((SELECT	SUM(NVL(OP_CNTR_QTY,0))" ).append("\n"); 
		query.append("FROM	BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	SUBSTR(CNTR_TPSZ_CD,2,1) != '2'" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD != 'Q4'),0) IN_FEU," ).append("\n"); 
		query.append("NVL((SELECT	SUM(NVL(OP_CNTR_QTY,0))" ).append("\n"); 
		query.append("FROM	BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD != 'Q2'" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD != 'Q4'),0) IN_QTY" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}