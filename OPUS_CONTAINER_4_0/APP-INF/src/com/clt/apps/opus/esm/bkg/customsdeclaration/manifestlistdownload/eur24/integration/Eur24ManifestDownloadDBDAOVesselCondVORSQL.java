/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOVesselCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOVesselCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VesselCondVO 생성을 위해 사용 (VesselArrivalCondVO 상속 받음)
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOVesselCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOVesselCondVORSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("'' bl_no," ).append("\n"); 
		query.append("'' vvd," ).append("\n"); 
		query.append("'' cntr_no," ).append("\n"); 
		query.append("'' cstms_port_cd," ).append("\n"); 
		query.append("'' edi_rcv_dt," ).append("\n"); 
		query.append("'' edi_rcv_seq," ).append("\n"); 
		query.append("'' cvy_ref_no," ).append("\n"); 
		query.append("'' eur_edi_msg_tp_id," ).append("\n"); 
		query.append("'' cstms_yd_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}