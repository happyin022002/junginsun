/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOSearchKorTransCrossChkCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOSearchKorTransCrossChkCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. 2011.01.19 이수진 
	  *    : Transmit Cross-Check Input Raram VO를 만들기 위한 쿼리
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOSearchKorTransCrossChkCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOSearchKorTransCrossChkCondVORSQL").append("\n"); 
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
		query.append("SELECT '' RAD_DEP_TYPE" ).append("\n"); 
		query.append(", '' RAD_VVD" ).append("\n"); 
		query.append(", '' DEP_TYPE" ).append("\n"); 
		query.append(", '' START_DT" ).append("\n"); 
		query.append(", '' END_DT" ).append("\n"); 
		query.append(", '' POL" ).append("\n"); 
		query.append(", '' POD" ).append("\n"); 
		query.append(", '' VVD" ).append("\n"); 
		query.append(", '' OPR_TYPE" ).append("\n"); 
		query.append(", '' RAD_TRANS_TYPE" ).append("\n"); 
		query.append(", '' SEL_TYPE" ).append("\n"); 
		query.append(", '' RAD_LANE_TYPE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}