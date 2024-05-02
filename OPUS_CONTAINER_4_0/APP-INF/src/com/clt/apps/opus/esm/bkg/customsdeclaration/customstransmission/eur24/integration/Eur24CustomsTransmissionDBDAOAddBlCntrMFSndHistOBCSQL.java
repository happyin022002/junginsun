/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOAddBlCntrMFSndHistOBCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.07.12 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOAddBlCntrMFSndHistOBCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOAddBlCntrMFSndHistOBCSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOAddBlCntrMFSndHistOBCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOAddBlCntrMFSndHistOBCSQL").append("\n"); 
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
		query.append("/* ENS에서 네덜란드를 위해 했으나 EXS에는 할 필요 없음. 일단 만들어 놓고 필요시 쿼리를 수정한다. 2011.07.12 */" ).append("\n"); 
		query.append("INSERT INTO BKG_CSTMS_EUR_CNTR_MF_SND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD, CNTR_NO, CNTR_CGO_SEQ, " ).append("\n"); 
		query.append("EDI_SND_SEQ, " ).append("\n"); 
		query.append("CNTR_MF_MK_DESC, CNTR_MF_GDS_DESC, PCK_QTY, PCK_TP_CD, CNTR_MF_WGT, WGT_UT_CD, MEAS_QTY, MEAS_UT_CD, CMDT_HS_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, MF_ITM_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD, CNTR_NO, CNTR_CGO_SEQ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(MAX(EDI_SND_SEQ),0)+1" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CNTR_MF_SND  " ).append("\n"); 
		query.append("    WHERE BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("    AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("CNTR_MF_MK_DESC, CNTR_MF_GDS_DESC, PCK_QTY, PCK_TP_CD, CNTR_MF_WGT, WGT_UT_CD, MEAS_QTY, MEAS_UT_CD, CMDT_HS_CD, @[cre_usr_id], SYSDATE, @[cre_usr_id], SYSDATE" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (ORDER BY CNTR_NO,CNTR_CGO_SEQ)" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_CNTR_MF X" ).append("\n"); 
		query.append("WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X' FROM BKG_CSTMS_EUR_CNTR C" ).append("\n"); 
		query.append("             WHERE C.VSL_cD = X.VSL_CD" ).append("\n"); 
		query.append("             AND C.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND C.SKD_DIR_CD = X.SKD_dIR_CD" ).append("\n"); 
		query.append("             AND C.CSTMS_PORT_CD = X.CSTMS_PORT_CD" ).append("\n"); 
		query.append("             AND C.BL_NO = X.BL_NO" ).append("\n"); 
		query.append("             AND C.CNTR_NO = X.CNTR_NO)" ).append("\n"); 

	}
}