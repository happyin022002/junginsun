/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MyanmarCustomsTransmissionDBDAOSearchMarkInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.04 
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

public class MyanmarCustomsTransmissionDBDAOSearchMarkInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MyanmarCustomsTransmissionDBDAOSearchMarkInfoRSQL(){
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
		query.append("FileName : MyanmarCustomsTransmissionDBDAOSearchMarkInfoRSQL").append("\n"); 
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
		query.append("SELECT    BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 1, 35),'J') MARK1" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 36, 35),'J') MARK2" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 71, 35),'J') MARK3         " ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 106, 35),'Y') MARK4" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 141, 35),'Y') MARK5" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 176, 35),'Y') MARK6" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 211, 35),'Y') MARK7" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 246, 35),'Y') MARK8" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 281, 35),'Y') MARK9" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 316, 35),'Y') MARK10" ).append("\n"); 
		query.append("FROM      BKG_BL_MK_DESC MD" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       MD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND       MD.MK_DESC IS NOT NULL" ).append("\n"); 

	}
}