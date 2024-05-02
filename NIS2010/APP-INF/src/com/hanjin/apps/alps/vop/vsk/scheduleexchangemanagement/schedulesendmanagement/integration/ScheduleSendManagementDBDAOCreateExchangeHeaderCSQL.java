/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ScheduleSendManagementDBDAOCreateExchangeHeaderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleSendManagementDBDAOCreateExchangeHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Exchange Header 데이터 생성
	  * </pre>
	  */
	public ScheduleSendManagementDBDAOCreateExchangeHeaderCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_hdr_msg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleSendManagementDBDAOCreateExchangeHeaderCSQL").append("\n"); 
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
		query.append("INSERT INTO   VSK_VSL_SKD_XCH_EDI_HDR  H" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("               H.SND_RCV_KND_CD" ).append("\n"); 
		query.append("            ,  H.SKD_EDI_RCV_DT" ).append("\n"); 
		query.append("            ,  H.SKD_EDI_RCV_SEQ" ).append("\n"); 
		query.append("            ,  H.VSL_CD_CTNT" ).append("\n"); 
		query.append("            ,  H.SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("            ,  H.SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("            ,  H.EDI_HDR_MSG" ).append("\n"); 
		query.append("            ,  H.EDI_FUNC_CD_CTNT" ).append("\n"); 
		query.append("            ,  H.CO_CD_CTNT" ).append("\n"); 
		query.append("            ,  H.VSL_SLAN_CD_CTNT" ).append("\n"); 
		query.append("            ,  H.SKD_CNG_STS_CD_CTNT" ).append("\n"); 
		query.append("            ,  H.ARR_DEP_IND_CD_CTNT" ).append("\n"); 
		query.append("            ,  H.CALL_SGN_NO" ).append("\n"); 
		query.append("            ,  H.LLOYD_NO" ).append("\n"); 
		query.append("            ,  H.SHP_CALL_NO" ).append("\n"); 
		query.append("            ,  H.VSL_ENG_NM" ).append("\n"); 
		query.append("            ,  H.PIC_NM" ).append("\n"); 
		query.append("            ,  H.PIC_CNTC_TP_CD" ).append("\n"); 
		query.append("            ,  H.PIC_CNTC_NO" ).append("\n"); 
		query.append("            ,  H.EDI_RMK" ).append("\n"); 
		query.append("            ,  H.MAPG_SCS_FLG" ).append("\n"); 
		query.append("            ,  H.EDI_PROC_RMK" ).append("\n"); 
		query.append("            ,  H.CRE_USR_ID" ).append("\n"); 
		query.append("            ,  H.CRE_DT" ).append("\n"); 
		query.append("            ,  H.UPD_USR_ID" ).append("\n"); 
		query.append("            ,  H.UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT      " ).append("\n"); 
		query.append("               'S'                     		/*  SND_RCV_KND_CD           */" ).append("\n"); 
		query.append("            ,  TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD')   /*  SKD_EDI_RCV_DT          */" ).append("\n"); 
		query.append("            ,  @[skd_edi_rcv_seq]      		/*  SKD_EDI_RCV_SEQ         */" ).append("\n"); 
		query.append("            ,  VS.VSL_CD               		/*  VSL_CD_CTNT             */" ).append("\n"); 
		query.append("            ,  VS.SKD_VOY_NO           		/*  SKD_VOY_NO_CTNT         */" ).append("\n"); 
		query.append("            ,  VS.SKD_DIR_CD           		/*  SKD_DIR_CD_CTNT         */" ).append("\n"); 
		query.append("            --,  [edi_hdr_msg]          		/*  EDI_HDR_MSG             */" ).append("\n"); 
		query.append("			,  '$$$MSGSTART:'||RPAD('SML',20,' ')||RPAD(DECODE(@[co_cd_ctnt],'YML','CKY','KKL','KKL','COS','XXX','***'),20,' ')||RPAD('IFTSAI',10,' ')||'ENT'||SUBSTR(LPAD(@[edi_hdr_msg],11,'0'),1,11)" ).append("\n"); 
		query.append("			--,  'ENT'||[edi_hdr_msg]" ).append("\n"); 
		query.append("            ,  ''                      		/*  EDI_FUNC_CD_CTNT        */" ).append("\n"); 
		query.append("            ,  @[co_cd_ctnt]           		/*  CO_CD_CTNT              */" ).append("\n"); 
		query.append("            ,  VS.VSL_SLAN_CD          		/*  VSL_SLAN_CD_CTNT        */" ).append("\n"); 
		query.append("            ,  ''                      		/*  SKD_CNG_STS_CD_CTNT     */" ).append("\n"); 
		query.append("            ,  ''                      		/*  ARR_DEP_IND_CD_CTNT     */" ).append("\n"); 
		query.append("            ,  ''                      		/*  CALL_SGN_NO             */" ).append("\n"); 
		query.append("            ,  VC.LLOYD_NO             		/*  LLOYD_NO                */" ).append("\n"); 
		query.append("            ,  ''                      		/*  SHP_CALL_NO             */" ).append("\n"); 
		query.append("            ,  VC.VSL_ENG_NM           		/*  VSL_ENG_NM              */" ).append("\n"); 
		query.append("            ,  (SELECT X.USR_NM  FROM COM_USER X WHERE X.USR_ID = @[upd_usr_id]) /*  PIC_NM                  */" ).append("\n"); 
		query.append("            ,  ''    						/*  PIC_CNTC_TP_CD          */" ).append("\n"); 
		query.append("            ,  (SELECT X.USR_EML FROM COM_USER X WHERE X.USR_ID = @[upd_usr_id]) /*  PIC_CNTC_NO  (E-MAIL)   */" ).append("\n"); 
		query.append("            ,  ''                      		/*  EDI_RMK                 */" ).append("\n"); 
		query.append("            ,  ''                     		/*  MAPG_SCS_FLG            */" ).append("\n"); 
		query.append("            ,  ''                      		/*  EDI_PROC_RMK            */" ).append("\n"); 
		query.append("            ,  @[cre_usr_id]           		/*  CRE_USR_ID              */" ).append("\n"); 
		query.append("            ,  SYSDATE                 		/*  CRE_DT                  */" ).append("\n"); 
		query.append("            ,  @[upd_usr_id]           		/*  UPD_USR_ID              */" ).append("\n"); 
		query.append("            ,  SYSDATE                 		/*  UPD_DT              */" ).append("\n"); 
		query.append("FROM        	VSK_VSL_SKD                VS" ).append("\n"); 
		query.append("        	,   MDM_VSL_CNTR               VC" ).append("\n"); 
		query.append("WHERE       	1 = 1" ).append("\n"); 
		query.append("AND         	VS.VSL_CD                  = VC.VSL_CD" ).append("\n"); 
		query.append("AND         	VS.VSL_CD                  = @[vsl_cd_ctnt]" ).append("\n"); 
		query.append("AND         	VS.SKD_VOY_NO              = @[skd_voy_no_ctnt]" ).append("\n"); 
		query.append("AND         	VS.SKD_DIR_CD              = @[skd_dir_cd_ctnt]" ).append("\n"); 

	}
}