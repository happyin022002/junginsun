/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarCustomsTransmissionDBDAOsearchVVDCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarCustomsTransmissionDBDAOsearchVVDCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVVDCnt
	  * </pre>
	  */
	public MyanmarCustomsTransmissionDBDAOsearchVVDCntRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.integration").append("\n"); 
		query.append("FileName : MyanmarCustomsTransmissionDBDAOsearchVVDCntRSQL").append("\n"); 
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
		query.append("SELECT CASE VVD_CNT WHEN 1 THEN 'N'" ).append("\n"); 
		query.append("	   ELSE 'Y'" ).append("\n"); 
		query.append("	   END CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT COUNT(0) VVD_CNT" ).append("\n"); 
		query.append("		FROM BKG_VVD" ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no])" ).append("\n"); 

	}
}