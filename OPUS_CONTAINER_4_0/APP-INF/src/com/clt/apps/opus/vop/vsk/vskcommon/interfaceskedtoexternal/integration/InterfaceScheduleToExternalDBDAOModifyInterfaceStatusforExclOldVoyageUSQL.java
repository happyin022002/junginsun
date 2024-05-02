/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforExclOldVoyageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforExclOldVoyageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F 대상제외처리
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforExclOldVoyageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_if_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforExclOldVoyageUSQL").append("\n"); 
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
		query.append("UPDATE    VSK_VSL_SKD_VIPS_IF_HDR   X" ).append("\n"); 
		query.append("SET       X.VIPS_IF_TGT_FLG         = 'N'" ).append("\n"); 
		query.append("       ,  X.VIPS_IF_RMK             = SUBSTR(X.VIPS_IF_RMK,1,3000)" ).append("\n"); 
		query.append("									  ||CHR(10)||'-------------------------------------------------------------'" ).append("\n"); 
		query.append("									  ||CHR(10)||' > '||'I/F TIME : ['||TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH24:MI:SS FF6')||']'" ).append("\n"); 
		query.append("									  ||CHR(10)||' > '||NVL(@[vips_if_rmk]	,'Update Interface Target Indicator to be excluded by System')" ).append("\n"); 
		query.append("									  ||CHR(10)||'-------------------------------------------------------------'" ).append("\n"); 
		query.append("									  ||CHR(10)" ).append("\n"); 
		query.append("       ,  X.UPD_USR_ID              = 'EXCL IF TGT BY SYS'" ).append("\n"); 
		query.append("       ,  X.UPD_DT                  = SYSDATE" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       X.VIPS_IF_TGT_FLG         = 'Y'" ).append("\n"); 
		query.append("AND       X.VSL_CD                  = @[vsl_cd]" ).append("\n"); 
		query.append("AND       X.SKD_VOY_NO              = @[skd_voy_no]     " ).append("\n"); 
		query.append("AND       X.VIPS_IF_SEQ             < @[vips_if_seq]" ).append("\n"); 

	}
}