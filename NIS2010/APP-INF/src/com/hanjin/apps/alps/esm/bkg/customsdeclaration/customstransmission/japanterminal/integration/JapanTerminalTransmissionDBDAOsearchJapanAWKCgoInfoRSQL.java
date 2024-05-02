/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flat file AWK 카고 정보 조회
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL").append("\n"); 
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
		query.append("--OVH             		C	6	Over Height				AWKWARD_CGO.ak_hgt	BKG_TML_EDI_JP_AWK_CGO" ).append("\n"); 
		query.append("--OVLW            		C	6	Over Width (Left)				AWKWARD_CGO.ak_owp	BKG_TML_EDI_JP_AWK_CGO" ).append("\n"); 
		query.append("--OVRW            		C	6	Over Width (Right)				AWKWARD_CGO.ak_ows	BKG_TML_EDI_JP_AWK_CGO" ).append("\n"); 
		query.append("--OVFR      		C	6	Front+Rear					BKG_TML_EDI_JP_AWK_CGO" ).append("\n"); 
		query.append("--VOID_SLOT       		C	2	VOID Space		Void Space(FEU) x 2 = TEU		DANGER_CGO.DG_MARI_POLL	BKG_TML_EDI_JP_AWK_CGO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT OVR_HGT            OVH" ).append("\n"); 
		query.append(",OVR_LF_LEN               OVLW" ).append("\n"); 
		query.append(",OVR_RT_LEN               OVRW " ).append("\n"); 
		query.append(",OVR_FWRD_LEN+OVR_BKWD_LEN  OVFR" ).append("\n"); 
		query.append(",OVR_VOID_SLT_QTY * 2       VOID_SLOT " ).append("\n"); 
		query.append("FROM BKG_TML_EDI_JP_AWK_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("AND BKG_SKD_SEQ = 0" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD=@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD,OVR_HGT" ).append("\n"); 
		query.append(",OVR_LF_LEN" ).append("\n"); 
		query.append(",OVR_RT_LEN" ).append("\n"); 
		query.append(",OVR_FWRD_LEN+OVR_BKWD_LEN" ).append("\n"); 
		query.append(",OVR_VOID_SLT_QTY" ).append("\n"); 

	}
}