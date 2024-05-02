/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlFromPortSkdListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
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

public class InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlFromPortSkdListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F DETAIL 데이터생성 from VSK_VSL_PORT_SKD
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlFromPortSkdListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlFromPortSkdListCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_VIPS_IF_DTL" ).append("\n"); 
		query.append("  		(" ).append("\n"); 
		query.append("		   VSL_CD" ).append("\n"); 
		query.append("		  ,SKD_VOY_NO" ).append("\n"); 
		query.append("		  ,SKD_DIR_CD" ).append("\n"); 
		query.append("		  ,VIPS_IF_SEQ" ).append("\n"); 
		query.append("		  ,VPS_PORT_CD" ).append("\n"); 
		query.append("		  ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("		  ,CLPT_SEQ" ).append("\n"); 
		query.append("		  ,PORT_SKD_STS_CD" ).append("\n"); 
		query.append("		  ,YD_CD" ).append("\n"); 
		query.append("		  ,CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("		  ,SKD_CNG_STS_CD" ).append("\n"); 
		query.append("		  ,VIPS_IB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("		  ,VIPS_OB_CONSORTIUM_VOY_NO " ).append("\n"); 
		query.append("		  ,PF_ETA_DT" ).append("\n"); 
		query.append("		  ,PF_ETB_DT" ).append("\n"); 
		query.append("		  ,PF_ETD_DT" ).append("\n"); 
		query.append("		  ,INIT_ETA_DT             " ).append("\n"); 
		query.append("		  ,INIT_ETB_DT" ).append("\n"); 
		query.append("		  ,INIT_ETD_DT             " ).append("\n"); 
		query.append("		  ,VIPS_VPS_ETA_DT" ).append("\n"); 
		query.append("		  ,VIPS_VPS_ETB_DT" ).append("\n"); 
		query.append("		  ,VIPS_VPS_ETD_DT" ).append("\n"); 
		query.append("		  ,VIPS_ACT_ARR_DT" ).append("\n"); 
		query.append("		  ,VIPS_ACT_BRTH_DT" ).append("\n"); 
		query.append("		  ,VIPS_ACT_DEP_DT" ).append("\n"); 
		query.append("		  ,VIPS_MODI_LOC_CD" ).append("\n"); 
		query.append("		  ,TURN_PORT_FLG" ).append("\n"); 
		query.append("		  ,TURN_PORT_IND_CD" ).append("\n"); 
		query.append("		  ,TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("		  ,TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("		  ,TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		  ,VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("		  ,VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("		  ,VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("		  ,SKD_UPD_USR_ID" ).append("\n"); 
		query.append("		  ,SKD_UPD_USR_NM" ).append("\n"); 
		query.append("		  ,SKD_UPD_DT" ).append("\n"); 
		query.append("		  ,ADD_CALL_FLG" ).append("\n"); 
		query.append("		  ,VT_ADD_CALL_FLG      " ).append("\n"); 
		query.append("		  ,CRE_USR_ID" ).append("\n"); 
		query.append("		  ,CRE_DT" ).append("\n"); 
		query.append("		  ,UPD_USR_ID" ).append("\n"); 
		query.append("		  ,UPD_DT" ).append("\n"); 
		query.append("  		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT     PS.VSL_CD" ).append("\n"); 
		query.append("	      ,PS.SKD_VOY_NO" ).append("\n"); 
		query.append("	      ,PS.SKD_DIR_CD" ).append("\n"); 
		query.append("	      ,@[vips_if_seq]        	AS VIPS_IF_SEQ" ).append("\n"); 
		query.append("	      ,PS.VPS_PORT_CD" ).append("\n"); 
		query.append("	      ,PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	      ,PS.CLPT_SEQ" ).append("\n"); 
		query.append("	      ,PS.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("	      ,PS.YD_CD" ).append("\n"); 
		query.append("	      ,PS.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("	      ,PS.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("	      ,PS.IB_CSSM_VOY_NO " ).append("\n"); 
		query.append("	      ,PS.OB_CSSM_VOY_NO " ).append("\n"); 
		query.append("	      ,PS.PF_ETA_DT" ).append("\n"); 
		query.append("	      ,PS.PF_ETB_DT" ).append("\n"); 
		query.append("	      ,PS.PF_ETD_DT" ).append("\n"); 
		query.append("	      ,PS.INIT_ETA_DT             " ).append("\n"); 
		query.append("	      ,PS.INIT_ETB_DT" ).append("\n"); 
		query.append("	      ,PS.INIT_ETD_DT             " ).append("\n"); 
		query.append("	      ,PS.VPS_ETA_DT        AS VIPS_VPS_ETA_DT" ).append("\n"); 
		query.append("	      ,PS.VPS_ETB_DT    	AS VIPS_VPS_ETB_DT" ).append("\n"); 
		query.append("	      ,PS.VPS_ETD_DT    	AS VIPS_VPS_ETD_DT" ).append("\n"); 
		query.append("	      ,AK.ACT_ARR_DT    	AS VIPS_ACT_ARR_DT" ).append("\n"); 
		query.append("	      ,AK.ACT_BRTH_DT   	AS VIPS_ACT_BRTH_DT" ).append("\n"); 
		query.append("	      ,AK.ACT_DEP_DT    	AS VIPS_ACT_DEP_DT" ).append("\n"); 
		query.append("	      ,(SELECT MODI_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = PS.VPS_PORT_CD) 						AS VIPS_MODI_LOC_CD" ).append("\n"); 
		query.append("	      ,PS.TURN_PORT_FLG" ).append("\n"); 
		query.append("	      ,PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	      ,PS.TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("	      ,PS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	      ,PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	      ,(CASE WHEN PS.TURN_PORT_IND_CD    IN ('D','V','F')   THEN '' ELSE 'Y' END)      				AS VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("	      ,(CASE WHEN PS.CLPT_SEQ = '1'         				THEN '' ELSE 'Y' END)       			AS VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("	      ,'Y'                                            												AS VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("	      ,SUBSTR((CASE WHEN PS.UPD_USR_ID = 'IF_EDI_SVC' 				THEN 'IF_EDI' ELSE PS.UPD_USR_ID END),1,8)	AS SKD_UPD_USR_ID" ).append("\n"); 
		query.append("	      ,SUBSTR(NVL((SELECT USR_NM  FROM COM_USER WHERE USR_ID = PS.UPD_USR_ID),'IF_EDI'),1,20)        			AS SKD_UPD_USR_NM" ).append("\n"); 
		query.append("	      ,PS.UPD_DT                                        											AS SKD_UPD_DT" ).append("\n"); 
		query.append("	      ,PS.ADD_CALL_FLG" ).append("\n"); 
		query.append("	      ,PS.VT_ADD_CALL_FLG      " ).append("\n"); 
		query.append("	      ,'VIPS_IF'                                        											AS CRE_USR_ID" ).append("\n"); 
		query.append("	      ,SYSDATE                                          											AS CRE_DT" ).append("\n"); 
		query.append("	      ,'VIPS_IF'                                        											AS UPD_USR_ID" ).append("\n"); 
		query.append("	      ,SYSDATE                                          											AS UPD_DT" ).append("\n"); 
		query.append("FROM       VSK_VSL_PORT_SKD   	PS" ).append("\n"); 
		query.append("         , VSK_ACT_PORT_SKD   	AK" ).append("\n"); 
		query.append("WHERE      1 = 1" ).append("\n"); 
		query.append("AND        PS.VSL_CD         	= AK.VSL_CD                  (+)" ).append("\n"); 
		query.append("AND        PS.SKD_VOY_NO     	= AK.SKD_VOY_NO              (+)" ).append("\n"); 
		query.append("AND        PS.SKD_DIR_CD     	= AK.SKD_DIR_CD              (+)" ).append("\n"); 
		query.append("AND        PS.VPS_PORT_CD    	= AK.VPS_PORT_CD             (+)" ).append("\n"); 
		query.append("AND        PS.CLPT_IND_SEQ   	= AK.CLPT_IND_SEQ            (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND        PS.VSL_CD      		= @[vsl_cd]" ).append("\n"); 
		query.append("AND        PS.SKD_VOY_NO    	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND        PS.SKD_DIR_CD    	= @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY   PS.CLPT_SEQ      	ASC" ).append("\n"); 
		query.append("          ,PS.VPS_ETB_DT    	ASC" ).append("\n"); 

	}
}