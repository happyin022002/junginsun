/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : HangerInventoryMgtDBDAOremoveHangerInventoryDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.09.21 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HangerInventoryMgtDBDAOremoveHangerInventoryDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HangerInventoryMgtDBDAOremoveHangerInventoryDataDSQL
	  * </pre>
	  */
	public HangerInventoryMgtDBDAOremoveHangerInventoryDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.integration").append("\n"); 
		query.append("FileName : HangerInventoryMgtDBDAOremoveHangerInventoryDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_HNGR_INVT" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND MNR_HNGR_BAR_TP_CD=@[mnr_hngr_bar_tp_cd]" ).append("\n"); 

	}
}