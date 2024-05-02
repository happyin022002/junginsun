/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315PrefixMainCOPInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.31
*@LastModifier : 이경원
*@LastVersion : 1.0
* 2011.08.31 이경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee KyungWon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315PrefixMainCOPInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * subVO - COPInfo
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315PrefixMainCOPInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315PrefixMainCOPInfoRSQL").append("\n"); 
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
		query.append("''por_name," ).append("\n"); 
		query.append("''por_code," ).append("\n"); 
		query.append("''por_amsqual," ).append("\n"); 
		query.append("''por_amsport," ).append("\n"); 
		query.append("''pol_name," ).append("\n"); 
		query.append("''pol_code," ).append("\n"); 
		query.append("''pol_amsqual," ).append("\n"); 
		query.append("''pol_amsport," ).append("\n"); 
		query.append("''pod_name," ).append("\n"); 
		query.append("''pod_code," ).append("\n"); 
		query.append("''pod_amsqual," ).append("\n"); 
		query.append("''pod_amsport," ).append("\n"); 
		query.append("''del_name," ).append("\n"); 
		query.append("''del_code," ).append("\n"); 
		query.append("''del_amsqual," ).append("\n"); 
		query.append("''del_amsport," ).append("\n"); 
		query.append("''por_etd," ).append("\n"); 
		query.append("''por_etd_gmt," ).append("\n"); 
		query.append("''por_atd," ).append("\n"); 
		query.append("''por_atd_gmt," ).append("\n"); 
		query.append("''pol_eta," ).append("\n"); 
		query.append("''pol_eta_gmt," ).append("\n"); 
		query.append("''pol_ata," ).append("\n"); 
		query.append("''pol_ata_gmt," ).append("\n"); 
		query.append("''pol_etd," ).append("\n"); 
		query.append("''pol_etd_gmt," ).append("\n"); 
		query.append("''pol_atd," ).append("\n"); 
		query.append("''pol_atd_gmt," ).append("\n"); 
		query.append("''pod_eta," ).append("\n"); 
		query.append("''pod_eta_gmt," ).append("\n"); 
		query.append("''pod_ata," ).append("\n"); 
		query.append("''pod_ata_gmt," ).append("\n"); 
		query.append("''pod_etd," ).append("\n"); 
		query.append("''pod_etd_gmt," ).append("\n"); 
		query.append("''pod_atd," ).append("\n"); 
		query.append("''pod_atd_gmt," ).append("\n"); 
		query.append("''pod_etb," ).append("\n"); 
		query.append("''pod_etb_gmt," ).append("\n"); 
		query.append("''pod_atb," ).append("\n"); 
		query.append("''pod_atb_gmt," ).append("\n"); 
		query.append("''del_eta," ).append("\n"); 
		query.append("''del_eta_gmt," ).append("\n"); 
		query.append("''del_ata," ).append("\n"); 
		query.append("''del_ata_gmt," ).append("\n"); 
		query.append("''del_nod" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}