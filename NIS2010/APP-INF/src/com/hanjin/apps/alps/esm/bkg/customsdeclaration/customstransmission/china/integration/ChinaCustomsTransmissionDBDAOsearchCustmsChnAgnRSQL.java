/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCustmsChnAgnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.08.05 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchCustmsChnAgnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaCustomsTransmissionDBDAOsearchCustmsChnAgnRSQL
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCustmsChnAgnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCustmsChnAgnRSQL").append("\n"); 
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
		query.append("AGN_CTRL_OFC_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", CHN_CSTMS_AGN_CD" ).append("\n"); 
		query.append(", SLAN_CD" ).append("\n"); 
		query.append(", CHN_CSTMS_AGN_NM" ).append("\n"); 
		query.append(", SUBSTR(EDI_RCV_ID,1,20) AS EDI_RCV_ID" ).append("\n"); 
		query.append(", EDI_SND_ID" ).append("\n"); 
		query.append(", CHN_CSTMS_AGN_RMK" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CHN_AGN_STUP" ).append("\n"); 
		query.append("WHERE (SLAN_CD, POD_CD) IN" ).append("\n"); 
		query.append("(SELECT SLAN_CD, POD_CD" ).append("\n"); 
		query.append("FROM bkg_vvd" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD 	 = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount > 1)" ).append("\n"); 
		query.append("OR #end BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SLAN_CD,POD_CD,EDI_RCV_ID" ).append("\n"); 

	}
}