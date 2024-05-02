/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOEur24VesselArrivalTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.27
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.05.27 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOEur24VesselArrivalTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24VesselArrivalTransmitVO 생성을 위해 사용
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOEur24VesselArrivalTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOEur24VesselArrivalTransmitVORSQL").append("\n"); 
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
		query.append(" '' VVD" ).append("\n"); 
		query.append(",'' FORM1_CVY_REF_NO" ).append("\n"); 
		query.append(",'' CVY_REF_NO" ).append("\n"); 
		query.append(",'' FORM1_VVD" ).append("\n"); 
		query.append(",'' CSTMS_PORT_CD" ).append("\n"); 
		query.append(",'' FORM1_CSTMS_PORT_CD" ).append("\n"); 
		query.append(",'' P_TYPE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}