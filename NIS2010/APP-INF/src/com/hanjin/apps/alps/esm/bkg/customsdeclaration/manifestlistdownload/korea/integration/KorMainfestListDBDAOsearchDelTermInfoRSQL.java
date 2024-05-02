/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMainfestListDBDAOsearchDelTermInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.16 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorMainfestListDBDAOsearchDelTermInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEL Code와 Delivery Term 정보를 조회한다.
	  * </pre>
	  */
	public KorMainfestListDBDAOsearchDelTermInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorMainfestListDBDAOsearchDelTermInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG.DEL_CD BKG_DEL_CD" ).append("\n"); 
		query.append(", MDM.LOC_NM MDM_LOC_NM" ).append("\n"); 
		query.append(", DECODE(BKG.DE_TERM_CD,'Y','CY','D','DOOR','S','CFS','T','TACKIE','O','FREE OUT','MIXED') DEL_TERM_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG, MDM_LOCATION MDM" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BKG.DEL_CD = MDM.LOC_CD" ).append("\n"); 

	}
}