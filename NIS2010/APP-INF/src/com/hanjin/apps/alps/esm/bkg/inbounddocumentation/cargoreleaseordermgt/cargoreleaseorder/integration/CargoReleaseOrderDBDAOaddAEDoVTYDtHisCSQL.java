/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddAEDoVTYDtHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOaddAEDoVTYDtHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 아랍 국가에 한해서 DO validity date를 수정 가능한데 이를 History로 관리하기 위함
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddAEDoVTYDtHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_vty_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddAEDoVTYDtHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_AE_VTY_DT_HIS" ).append("\n"); 
		query.append(" (BKG_NO          ," ).append("\n"); 
		query.append("  HIS_SEQ         ," ).append("\n"); 
		query.append("  DO_VTY_DT       ," ).append("\n"); 
		query.append("  CRE_USR_ID      ," ).append("\n"); 
		query.append("  CRE_DT          ," ).append("\n"); 
		query.append("  UPD_USR_ID      ," ).append("\n"); 
		query.append("  UPD_DT)" ).append("\n"); 
		query.append("(SELECT   " ).append("\n"); 
		query.append("  @[bkg_no]," ).append("\n"); 
		query.append("  NVL(MAX(HIS_SEQ),0) + 1," ).append("\n"); 
		query.append("  TO_DATE(REPLACE(@[do_vty_dt],'-',''),'YYYYMMDD')," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[upd_usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append(" FROM BKG_AE_VTY_DT_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no] ) " ).append("\n"); 

	}
}