/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HangerInventoryMgtDBDAOmodifyHangerInventoryDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.12.22 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HangerInventoryMgtDBDAOmodifyHangerInventoryDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HangerInventoryMgtDBDAOmodifyHangerInventoryData
	  * </pre>
	  */
	public HangerInventoryMgtDBDAOmodifyHangerInventoryDataUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration").append("\n"); 
		query.append("FileName : HangerInventoryMgtDBDAOmodifyHangerInventoryDataUSQL").append("\n"); 
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
		query.append("UPDATE  MNR_HNGR_INVT" ).append("\n"); 
		query.append("SET HNGR_INVT_LST_VER_FLG='N'" ).append("\n"); 
		query.append("WHERE HNGR_INVT_LST_VER_FLG='Y'" ).append("\n"); 
		query.append("AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND MNR_HNGR_BAR_TP_CD=@[mnr_hngr_bar_tp_cd]" ).append("\n"); 

	}
}