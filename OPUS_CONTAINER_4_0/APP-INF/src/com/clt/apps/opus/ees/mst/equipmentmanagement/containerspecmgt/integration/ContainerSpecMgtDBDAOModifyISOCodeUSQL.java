/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOModifyISOCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOModifyISOCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST IOS Container Type Size Modify
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOModifyISOCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iso_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iso_cntr_tpsz_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration ").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOModifyISOCodeUSQL").append("\n"); 
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
		query.append("UPDATE MST_ISO_CNTR_TP_SZ SET " ).append("\n"); 
		query.append("	ISO_CNTR_TPSZ_NM = @[iso_cntr_tpsz_nm]," ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	ISO_CNTR_TPSZ_CD = @[iso_cntr_tpsz_cd]" ).append("\n"); 

	}
}