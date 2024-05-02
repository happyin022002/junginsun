/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchEur24VesselArrivalTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchEur24VesselArrivalTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24VesselArrivalTransmitVO 생성용
	  * VesselArrivalTransmitVO를 상속받아야 함
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchEur24VesselArrivalTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration ").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchEur24VesselArrivalTransmitVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' vvd," ).append("\n"); 
		query.append("'' form1_cvy_ref_no," ).append("\n"); 
		query.append("'' cvy_ref_no," ).append("\n"); 
		query.append("'' form1_vvd," ).append("\n"); 
		query.append("'' cstms_port_cd," ).append("\n"); 
		query.append("'' form1_cstms_port_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}