/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOremoveRFSparePartInventoryDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOremoveRFSparePartInventoryDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOremoveRFSparePartInventoryDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOremoveRFSparePartInventoryDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_RF_SPR_PRT_INVT" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}