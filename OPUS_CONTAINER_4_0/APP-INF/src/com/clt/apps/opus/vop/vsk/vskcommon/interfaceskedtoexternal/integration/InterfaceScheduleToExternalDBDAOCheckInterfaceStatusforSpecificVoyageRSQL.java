/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOCheckInterfaceStatusforSpecificVoyageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.12 
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

public class InterfaceScheduleToExternalDBDAOCheckInterfaceStatusforSpecificVoyageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Voyage 기준의 VIPS I/F 확인
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOCheckInterfaceStatusforSpecificVoyageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : InterfaceScheduleToExternalDBDAOCheckInterfaceStatusforSpecificVoyageRSQL").append("\n"); 
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
		query.append("SELECT      NVL(MAX(Y.INSF_CNQE_VAL)	,'*')   AS INSF_CNQE_VAL      	--: 'S':SUCCESS, 'E':ERROR :-" ).append("\n"); 
		query.append("         ,  NVL(MAX(Y.INSF_DV_CD)		,'*')   AS INSF_DV_CD         	--: 'I':INSERT, 'U':UPDATE, 'D':DELETE :--" ).append("\n"); 
		query.append("         ,  NVL(MAX(Y.VIPS_IF_TGT_FLG)	,'*')  	AS VIPS_IF_TGT_FLG    	--: 'Y':To be interfaced, 'N':Interfaced already :-- " ).append("\n"); 
		query.append("         ,  MAX(Y.VIPS_IF_SEQ)               	AS VIPS_IF_SEQ" ).append("\n"); 
		query.append("         ,  NVL(MAX(Y.LATEST_IF_RSLT_CD),'*') 	AS LATEST_IF_RSLT_CD 	--: 'S':SUCCESS, 'E':ERROR :-" ).append("\n"); 
		query.append("		 ,  NVL(MAX(Y.LATEST_INSF_DV_CD),'*') 	AS LATEST_INSF_DV_CD 	--: 'I':INSERT, 'U':UPDATE, 'D':DELETE :--" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ,  MAX(Y.VSL_CD)                     	AS VSL_CD" ).append("\n"); 
		query.append("         ,  MAX(Y.SKD_VOY_NO)                 	AS SKD_VOY_NO" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("            ----------------------------------------------------------------------" ).append("\n"); 
		query.append("            SELECT		XX.INSF_CNQE_VAL  " ).append("\n"); 
		query.append("					,	XX.INSF_DV_CD    " ).append("\n"); 
		query.append("                    ,   XX.VIPS_IF_TGT_FLG   " ).append("\n"); 
		query.append("                    ,   XX.VIPS_IF_SEQ" ).append("\n"); 
		query.append("                	" ).append("\n"); 
		query.append("          			,	XX.INSF_CNQE_VAL LATEST_IF_RSLT_CD                   " ).append("\n"); 
		query.append("          			,	XX.INSF_DV_CD LATEST_INSF_DV_CD   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    ,  	XX.VSL_CD" ).append("\n"); 
		query.append("					,	XX.SKD_VOY_NO               " ).append("\n"); 
		query.append("            FROM       VSK_VSL_SKD_VIPS_IF_HDR   			XX" ).append("\n"); 
		query.append("            WHERE      XX.VSL_CD                  			= @[vsl_cd]" ).append("\n"); 
		query.append("            AND        XX.SKD_VOY_NO              			= @[skd_voy_no]   " ).append("\n"); 
		query.append("            AND        XX.VIPS_IF_SEQ                   	= (	SELECT   MAX(HH.VIPS_IF_SEQ)" ).append("\n"); 
		query.append("                                                             	FROM     VSK_VSL_SKD_VIPS_IF_HDR   HH" ).append("\n"); 
		query.append("                                                             	WHERE    HH.VSL_CD                 = XX.VSL_CD" ).append("\n"); 
		query.append("                                                             	AND      HH.SKD_VOY_NO             = XX.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                             	--AND      HH.INSF_CNQE_VAL          IS NOT NULL" ).append("\n"); 
		query.append("																AND      HH.INSF_CNQE_VAL          = 'S'	--:SUCCESS:--" ).append("\n"); 
		query.append("                                                               )  " ).append("\n"); 
		query.append("            ----------------------------------------------------------------------" ).append("\n"); 
		query.append("            ) Y" ).append("\n"); 

	}
}