/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchCustOrderTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchCustOrderTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Shipper Code에 따라 MDM Customer에서 Customer Type을 조회한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchCustOrderTypeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n"); 
		query.append("FileName : Kor24ManifestListDBDAOsearchCustOrderTypeRSQL").append("\n"); 
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
		query.append("SELECT MDM.RVIS_CNTR_CUST_TP_CD CUST_TYPE" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER CUST, MDM_CUSTOMER MDM, BKG_BOOKING BKG " ).append("\n"); 
		query.append("WHERE CUST.CUST_CNT_CD  = MDM.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ       = MDM.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = DECODE(BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("AND CUST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CUST.BKG_NO = BKG.BKG_NO" ).append("\n"); 

	}
}