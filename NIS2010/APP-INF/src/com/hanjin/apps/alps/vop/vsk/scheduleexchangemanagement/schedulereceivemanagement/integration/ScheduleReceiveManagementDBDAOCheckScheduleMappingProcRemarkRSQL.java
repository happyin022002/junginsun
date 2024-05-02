/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleReceiveManagementDBDAOCheckScheduleMappingProcRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleReceiveManagementDBDAOCheckScheduleMappingProcRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 매핑처리remark
	  * </pre>
	  */
	public ScheduleReceiveManagementDBDAOCheckScheduleMappingProcRemarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration").append("\n"); 
		query.append("FileName : ScheduleReceiveManagementDBDAOCheckScheduleMappingProcRemarkRSQL").append("\n"); 
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
		query.append("SELECT   'Validation Check Result ==> '|| " ).append("\n"); 
		query.append("         (SELECT    '['||DECODE(COUNT(1),0,'VVD does Not exist','VVD Exist')                 " ).append("\n"); 
		query.append("          FROM      VSK_VSL_SKD_XCH_EDI_HDR  H" ).append("\n"); 
		query.append("                 ,  VSK_VSL_SKD              VS" ).append("\n"); 
		query.append("          WHERE     1 = 1" ).append("\n"); 
		query.append("          AND       H.SND_RCV_KND_CD         = 'R'" ).append("\n"); 
		query.append("          AND       H.SKD_EDI_RCV_SEQ        = @[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("          AND       H.VSL_CD_CTNT            = VS.VSL_CD" ).append("\n"); 
		query.append("          AND       H.SKD_VOY_NO_CTNT        = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND       H.SKD_DIR_CD_CTNT        = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND       VS.SKD_STS_CD            = 'ACT'" ).append("\n"); 
		query.append("          )||'] and Port Mapping Count is ['||" ).append("\n"); 
		query.append("         (SELECT    COUNT(1)                 AS VVD_MAPG_KNT" ).append("\n"); 
		query.append("          FROM      VSK_VSL_SKD_XCH_EDI_DTL  D" ).append("\n"); 
		query.append("                 ,  VSK_VSL_PORT_SKD         PS" ).append("\n"); 
		query.append("          WHERE     1 = 1" ).append("\n"); 
		query.append("          AND       D.SND_RCV_KND_CD         = 'R'" ).append("\n"); 
		query.append("          AND       D.SKD_EDI_RCV_SEQ        = @[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("          AND       D.VSL_CD_CTNT            = PS.VSL_CD" ).append("\n"); 
		query.append("          AND       D.SKD_VOY_NO_CTNT        = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND       D.SKD_DIR_CD_CTNT        = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND       D.VPS_PORT_CD_CTNT       = PS.VPS_PORT_CD" ).append("\n"); 
		query.append("          )||']'||' of All Count is ['||" ).append("\n"); 
		query.append("         (SELECT    COUNT(1)" ).append("\n"); 
		query.append("          FROM      VSK_VSL_PORT_SKD         PS" ).append("\n"); 
		query.append("          WHERE     1 = 1" ).append("\n"); 
		query.append("          AND       PS.VSL_CD            = @[vsl_cd_ctnt]" ).append("\n"); 
		query.append("          AND       PS.SKD_VOY_NO        = @[skd_voy_no_ctnt]" ).append("\n"); 
		query.append("          AND       PS.SKD_DIR_CD        = @[skd_dir_cd_ctnt] " ).append("\n"); 
		query.append("		  AND	   	NVL(PS.SKD_CNG_STS_CD,'*') <> 'S'" ).append("\n"); 
		query.append("          )||']'" ).append("\n"); 
		query.append("          AS        EDI_PROC_RMK" ).append("\n"); 
		query.append("FROM      DUAL          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 " ).append("\n"); 

	}
}