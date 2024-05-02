/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleReceiveManagementDBDAOUpdateCoastalSchedulebyEDICKYHUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
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

public class ScheduleReceiveManagementDBDAOUpdateCoastalSchedulebyEDICKYHUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CKYH로부터 수신한 EDI Schedule 데이터를 Coastal Schedule에 반영
	  * </pre>
	  */
	public ScheduleReceiveManagementDBDAOUpdateCoastalSchedulebyEDICKYHUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration").append("\n"); 
		query.append("FileName : ScheduleReceiveManagementDBDAOUpdateCoastalSchedulebyEDICKYHUSQL").append("\n"); 
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
		query.append("UPDATE  VSK_VSL_PORT_SKD   PPS" ).append("\n"); 
		query.append("SET     PPS.UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE   (PPS.VSL_CD,PPS.SKD_VOY_NO,PPS.SKD_DIR_CD,PPS.VPS_PORT_CD,PPS.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        --========================================================================" ).append("\n"); 
		query.append("        SELECT  PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD,PS.VPS_PORT_CD,PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        FROM    VSK_VSL_PORT_SKD   PS" ).append("\n"); 
		query.append("        WHERE   PS.VSL_CD          = @[vsl_cd_ctnt]" ).append("\n"); 
		query.append("        AND     PS.SKD_VOY_NO      = @[skd_voy_no_ctnt]" ).append("\n"); 
		query.append("        AND     PS.SKD_DIR_CD      = @[skd_dir_cd_ctnt]" ).append("\n"); 
		query.append("        AND     PS.CLPT_IND_SEQ    = 1" ).append("\n"); 
		query.append("        AND     PS.VPS_PORT_CD     IN (" ).append("\n"); 
		query.append("                                      SELECT    PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      FROM      VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                                             ,  VSK_VSL_SKD_XCH_EDI_DTL   D" ).append("\n"); 
		query.append("                                      WHERE     1 = 1" ).append("\n"); 
		query.append("                                      AND       PS.VSL_CD                 = D.VSL_CD_CTNT" ).append("\n"); 
		query.append("                                      AND       PS.SKD_VOY_NO             = D.SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("                                      AND       PS.SKD_DIR_CD             = D.SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("                                      AND       DECODE(PS.VPS_PORT_CD,'USLGB','0','USLAX','0',PS.VPS_PORT_CD)" ).append("\n"); 
		query.append("                                                                          = DECODE(D.VPS_PORT_CD_CTNT,'USLGB','0','USLAX','0',D.VPS_PORT_CD_CTNT)" ).append("\n"); 
		query.append("                                      AND       PS.CLPT_IND_SEQ           = 1" ).append("\n"); 
		query.append("                                      AND       D.SND_RCV_KND_CD          = 'R'" ).append("\n"); 
		query.append("                                      AND       D.SKD_EDI_RCV_SEQ         = @[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                      --SELECT    D.VPS_PORT_CD_CTNT" ).append("\n"); 
		query.append("                                      --FROM      VSK_VSL_SKD_XCH_EDI_DTL   D" ).append("\n"); 
		query.append("                                      --WHERE     D.SND_RCV_KND_CD          = 'R'" ).append("\n"); 
		query.append("                                      --AND       D.SKD_EDI_RCV_SEQ         = [skd_edi_rcv_seq]" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  PS.VSL_CD,PS.SKD_VOY_NO,PS.SKD_DIR_CD,PS.VPS_PORT_CD,PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        FROM    VSK_VSL_PORT_SKD      PS" ).append("\n"); 
		query.append("        WHERE   PS.VSL_CD             = @[vsl_cd_ctnt]" ).append("\n"); 
		query.append("        AND     PS.TURN_SKD_VOY_NO    = @[skd_voy_no_ctnt]" ).append("\n"); 
		query.append("        AND     PS.TURN_SKD_DIR_CD    = @[skd_dir_cd_ctnt]" ).append("\n"); 
		query.append("        AND     PS.TURN_CLPT_IND_SEQ  = 1" ).append("\n"); 
		query.append("        AND     PS.VPS_PORT_CD     	IN (" ).append("\n"); 
		query.append("                                      	SELECT    PS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      	FROM      VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                                               ,  VSK_VSL_SKD_XCH_EDI_DTL   D" ).append("\n"); 
		query.append("                                        WHERE     1 = 1" ).append("\n"); 
		query.append("                                      	AND       PS.VSL_CD                 = D.VSL_CD_CTNT" ).append("\n"); 
		query.append("                                      	AND       PS.SKD_VOY_NO             = D.SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("                                      	AND       PS.SKD_DIR_CD             = D.SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("                                      	AND       DECODE(PS.VPS_PORT_CD,'USLGB','0','USLAX','0',PS.VPS_PORT_CD)" ).append("\n"); 
		query.append("                                                                          	= DECODE(D.VPS_PORT_CD_CTNT,'USLGB','0','USLAX','0',D.VPS_PORT_CD_CTNT)" ).append("\n"); 
		query.append("                                      	AND       PS.CLPT_IND_SEQ           = 1" ).append("\n"); 
		query.append("                                      	AND       D.SND_RCV_KND_CD          = 'R'" ).append("\n"); 
		query.append("                                      	AND       D.SKD_EDI_RCV_SEQ         = @[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                      	--SELECT    D.VPS_PORT_CD_CTNT" ).append("\n"); 
		query.append("                                      	--FROM      VSK_VSL_SKD_XCH_EDI_DTL   D" ).append("\n"); 
		query.append("                                      	--WHERE     D.SND_RCV_KND_CD          = 'R'" ).append("\n"); 
		query.append("                                      	--AND       D.SKD_EDI_RCV_SEQ         = [skd_edi_rcv_seq]" ).append("\n"); 
		query.append("                                      )    " ).append("\n"); 
		query.append("        --========================================================================" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}