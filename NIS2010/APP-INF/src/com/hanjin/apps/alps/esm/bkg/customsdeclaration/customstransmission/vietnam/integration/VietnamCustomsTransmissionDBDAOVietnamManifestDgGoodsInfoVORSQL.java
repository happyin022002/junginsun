/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOVietnamManifestDgGoodsInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.27 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOVietnamManifestDgGoodsInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VietnamManifestDgGoodsInfoVO
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOVietnamManifestDgGoodsInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOVietnamManifestDgGoodsInfoVORSQL").append("\n"); 
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
		query.append("'' imo_class_no," ).append("\n"); 
		query.append("'' imo_page_no," ).append("\n"); 
		query.append("'' hazard_cd," ).append("\n"); 
		query.append("'' undg_no," ).append("\n"); 
		query.append("'' flash_point," ).append("\n"); 
		query.append("'' flash_point_unit," ).append("\n"); 
		query.append("'' packing_group," ).append("\n"); 
		query.append("'' ems_no," ).append("\n"); 
		query.append("'' mfag," ).append("\n"); 
		query.append("'' trem_card_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}