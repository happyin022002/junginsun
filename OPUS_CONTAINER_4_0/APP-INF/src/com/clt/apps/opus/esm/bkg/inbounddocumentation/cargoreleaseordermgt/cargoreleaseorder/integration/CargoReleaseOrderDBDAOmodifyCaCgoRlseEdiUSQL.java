/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmodifyCaCgoRlseEdiUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOmodifyCaCgoRlseEdiUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOmodifyCaCgoRlseEdiUSQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmodifyCaCgoRlseEdiUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rcv_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmodifyCaCgoRlseEdiUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CGO_RLSE A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT @[bl_no] AS BL_NO" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (A.BL_NO = B.BL_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("   SET HBL_FLG	        = 'N',   " ).append("\n"); 
		query.append("#if (${frt_clt_flg} != '') " ).append("\n"); 
		query.append("       FRT_CLT_FLG		= @[frt_clt_flg]," ).append("\n"); 
		query.append("       FRT_CLT_LST_DT	= DECODE(@[frt_clt_flg],FRT_CLT_FLG,FRT_CLT_LST_DT,GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'CATOR'))," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${obl_rdem_flg} != '' )" ).append("\n"); 
		query.append("       OBL_RDEM_FLG	    = @[obl_rdem_flg]," ).append("\n"); 
		query.append("       OBL_RDEM_LST_DT	= DECODE(@[obl_rdem_flg],OBL_RDEM_FLG,OBL_RDEM_LST_DT,GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'CATOR'))," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       UPD_USR_ID		= @[usr_id]," ).append("\n"); 
		query.append("       UPD_DT			= SYSDATE," ).append("\n"); 
		query.append("       BL_RCV_KNT       = DECODE(NVL(TO_NUMBER(@[bl_rcv_knt]),0),0,NULL," ).append("\n"); 
		query.append("                              DECODE(TO_NUMBER(@[bl_rcv_knt]),BL_RCV_KNT,BL_RCV_KNT,@[bl_rcv_knt]))," ).append("\n"); 
		query.append("       BL_RCV_OFC_CD    = DECODE(NVL(TO_NUMBER(@[bl_rcv_knt]),0),0,NULL," ).append("\n"); 
		query.append("                              DECODE(TO_NUMBER(@[bl_rcv_knt]),BL_RCV_KNT,BL_RCV_OFC_CD,@[usr_ofc_cd]))," ).append("\n"); 
		query.append("       BL_RCV_USR_ID    = DECODE(NVL(TO_NUMBER(@[bl_rcv_knt]),0),0,NULL," ).append("\n"); 
		query.append("                              DECODE(TO_NUMBER(@[bl_rcv_knt]),BL_RCV_KNT,BL_RCV_USR_ID,@[usr_id]))," ).append("\n"); 
		query.append("       BL_RCV_DT        = TO_DATE(DECODE(NVL(TO_NUMBER(@[bl_rcv_knt]),0),0,NULL," ).append("\n"); 
		query.append("                              DECODE(TO_NUMBER(@[bl_rcv_knt]),BL_RCV_KNT,TO_CHAR(BL_RCV_DT,'YYYYMMDDHH24MISS'), " ).append("\n"); 
		query.append("                                     TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'CATOR'),'YYYYMMDDHH24MISS')))," ).append("\n"); 
		query.append("                          'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("        BL_NO                   ," ).append("\n"); 
		query.append("        HBL_FLG                 ," ).append("\n"); 
		query.append("        FRT_CLT_FLG             ," ).append("\n"); 
		query.append("        FRT_CLT_LST_DT          ," ).append("\n"); 
		query.append("        OBL_RDEM_FLG            ," ).append("\n"); 
		query.append("        OBL_RDEM_LST_DT         ," ).append("\n"); 
		query.append("        CSTMS_CLR_CD            ," ).append("\n"); 
		query.append("        CSTMS_CLR_LST_DT        ," ).append("\n"); 
		query.append("        CSTMS_DSPO_CD           ," ).append("\n"); 
		query.append("        MRN_TML_EDI_SND_FLG     ," ).append("\n"); 
		query.append("        MRN_TML_EDI_SND_CD      ," ).append("\n"); 
		query.append("        MRN_TML_EDI_LST_SND_DT  ," ).append("\n"); 
		query.append("        MRN_TML_EDI_LST_SND_GDT ," ).append("\n"); 
		query.append("        MRN_TML_EDI_RCV_ID      ," ).append("\n"); 
		query.append("        MRN_TML_EDI_LST_MSG_ID  ," ).append("\n"); 
		query.append("        MRN_TML_EDI_LST_SCS_FLG ," ).append("\n"); 
		query.append("        INLND_YD_EDI_SND_FLG    ," ).append("\n"); 
		query.append("        INLND_YD_EDI_SND_CD     ," ).append("\n"); 
		query.append("        INLND_YD_EDI_LST_SND_DT ," ).append("\n"); 
		query.append("        INLND_YD_EDI_LST_SND_GDT," ).append("\n"); 
		query.append("        INLND_YD_EDI_RCV_ID     ," ).append("\n"); 
		query.append("        INLND_YD_EDI_LST_MSG_ID ," ).append("\n"); 
		query.append("        INLND_YD_EDI_LST_SCS_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID              ," ).append("\n"); 
		query.append("        CRE_DT                  ," ).append("\n"); 
		query.append("        UPD_USR_ID              ," ).append("\n"); 
		query.append("        UPD_DT                  )" ).append("\n"); 
		query.append("VALUES (@[bl_no]," ).append("\n"); 
		query.append("        'N'           ," ).append("\n"); 
		query.append("        NVL(@[frt_clt_flg],'N')," ).append("\n"); 
		query.append("        GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'CATOR')," ).append("\n"); 
		query.append("        NVL(@[obl_rdem_flg],'N'),  " ).append("\n"); 
		query.append("        GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'CATOR')," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        NULL          ," ).append("\n"); 
		query.append("        @[usr_id]     ," ).append("\n"); 
		query.append("        SYSDATE       ," ).append("\n"); 
		query.append("        @[usr_id]     ," ).append("\n"); 
		query.append("        SYSDATE       )" ).append("\n"); 

	}
}