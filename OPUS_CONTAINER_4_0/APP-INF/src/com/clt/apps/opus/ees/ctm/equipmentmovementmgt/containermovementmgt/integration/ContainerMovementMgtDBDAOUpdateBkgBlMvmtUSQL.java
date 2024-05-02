/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOUpdateBkgBlMvmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOUpdateBkgBlMvmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM_BKG_BL_CMB Update
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOUpdateBkgBlMvmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cud_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOUpdateBkgBlMvmtUSQL").append("\n"); 
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
		query.append("UPDATE CTM_BKG_BL_CMB SET" ).append("\n"); 
		query.append("	BL_NO_TP	= 	NVL(@[bl_no_tp], 'N')  	," ).append("\n"); 
		query.append("	BL_TP_CD	= 	NVL(@[bl_tp_cd], 'N')	," ).append("\n"); 
		query.append("	DAT_MNPL_CD = 	NVL(@[cud_flg] , 'N')	," ).append("\n"); 
		query.append("	--CRE_USR_ID	= 	'Bridge'				," ).append("\n"); 
		query.append("	--CRE_DT		=	SYSDATE					,	" ).append("\n"); 
		query.append("	UPD_USR_ID	= 	'Bridge'				," ).append("\n"); 
		query.append("	UPD_DT		=	SYSDATE					" ).append("\n"); 
		query.append("WHERE 1=1  " ).append("\n"); 
		query.append("	AND BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("	AND BL_NO		= @[bl_no]" ).append("\n"); 

	}
}