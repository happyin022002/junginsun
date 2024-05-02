/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSABKGIFInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.17 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSABKGIFInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA Interface정보를 조회
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSABKGIFInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSABKGIFInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO BKG_NO" ).append("\n"); 
		query.append(", BKG.MTY_PKUP_YD_CD YD_CD" ).append("\n"); 
		query.append(", BQ.CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(BQ.OP_CNTR_QTY, 0),'990.99')) BKG_QTY" ).append("\n"); 
		query.append(", BQ.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", LTRIM(TO_CHAR(NVL(BQ.OP_CNTR_QTY, 0),'990.99')) CNTR_QTY" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(", BKG_QUANTITY BQ" ).append("\n"); 
		query.append("WHERE BQ.BKG_NO       = BKG.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("ORDER BY BQ.CNTR_TPSZ_CD" ).append("\n"); 

	}
}