/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToExternalScnDBDAOCreateSpecificPortScnInterfaceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalScnDBDAOCreateSpecificPortScnInterfaceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PORT CREATE
	  * </pre>
	  */
	public InterfaceScheduleToExternalScnDBDAOCreateSpecificPortScnInterfaceCSQL(){
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalScnDBDAOCreateSpecificPortScnInterfaceCSQL").append("\n"); 
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
		query.append("INSERT INTO  VSK_VSL_CSSM_VOY_NO_IF F" ).append("\n"); 
		query.append("             (   VSL_CD" ).append("\n"); 
		query.append("              ,  SKD_VOY_NO" ).append("\n"); 
		query.append("              ,  SKD_DIR_CD" ).append("\n"); 
		query.append("              ,  VPS_PORT_CD" ).append("\n"); 
		query.append("              ,  CSSM_VOY_NO_IF_SEQ" ).append("\n"); 
		query.append("              ,  VSL_SLAN_CD" ).append("\n"); 
		query.append("              ,  IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("              ,  OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("              ,  INSF_ID" ).append("\n"); 
		query.append("              ,  INSF_PRS_ID" ).append("\n"); 
		query.append("              ,  INSF_DTTM" ).append("\n"); 
		query.append("              ,  INSF_CNQE_VAL" ).append("\n"); 
		query.append("              ,  INSF_DV_CD" ).append("\n"); 
		query.append("              ,	INSF_CNQE_CONT" ).append("\n"); 
		query.append("              ,	CRE_USR_ID" ).append("\n"); 
		query.append("              ,	CRE_DT" ).append("\n"); 
		query.append("              ,	UPD_USR_ID" ).append("\n"); 
		query.append("              ,	UPD_DT" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("SELECT   PS.VSL_CD" ).append("\n"); 
		query.append("       , PS.SKD_VOY_NO" ).append("\n"); 
		query.append("       , PS.SKD_DIR_CD" ).append("\n"); 
		query.append("       , PS.VPS_PORT_CD" ).append("\n"); 
		query.append("       , VSK_VSL_CSSM_VOY_NO_IF_SEQ.NEXTVAL" ).append("\n"); 
		query.append("       , PS.SLAN_CD" ).append("\n"); 
		query.append("       , PS.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("       , PS.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("       , 'OPEDI002'" ).append("\n"); 
		query.append("       , ''" ).append("\n"); 
		query.append("       , ''" ).append("\n"); 
		query.append("       , ''" ).append("\n"); 
		query.append("       , 'I'" ).append("\n"); 
		query.append("       , ''" ).append("\n"); 
		query.append("       , PS.UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , PS.UPD_USR_ID" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("          SELECT   RANK() OVER (PARTITION BY PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD,PS.VPS_PORT_CD ORDER BY DECODE(PS.SKD_CNG_STS_CD,'S',9,1) ASC, PS.CLPT_IND_SEQ ASC) RNK" ).append("\n"); 
		query.append("                ,  PS.* " ).append("\n"); 
		query.append("          FROM     VSK_VSL_PORT_SKD        PS" ).append("\n"); 
		query.append("          WHERE    PS.VSL_CD               = @[vsl_cd]" ).append("\n"); 
		query.append("          AND      PS.SKD_VOY_NO           = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND      PS.SKD_DIR_CD           = @[skd_dir_cd]" ).append("\n"); 
		query.append("		  AND	   PS.VPS_PORT_CD		   = @[vps_port_cd]" ).append("\n"); 
		query.append("		  AND	   NVL(PS.VT_ADD_CALL_FLG,'N') = 'N'" ).append("\n"); 
		query.append("          )        PS" ).append("\n"); 
		query.append("WHERE     RNK      = 1" ).append("\n"); 

	}
}