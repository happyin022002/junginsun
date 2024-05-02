/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOsearchVerifyLocalTariffFileListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOsearchVerifyLocalTariffFileListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 - [EES_MNR_0190] Local Tariff 에서의 Verify 후의 조회
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOsearchVerifyLocalTariffFileListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("std_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOsearchVerifyLocalTariffFileListDataRSQL").append("\n"); 
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
		query.append("SELECT   A.INP_MSG17" ).append("\n"); 
		query.append("       , A.INP_MSG1" ).append("\n"); 
		query.append("       , A.INP_MSG2" ).append("\n"); 
		query.append("       , A.INP_MSG6" ).append("\n"); 
		query.append("       , A.INP_MSG7" ).append("\n"); 
		query.append("       , A.INP_MSG10" ).append("\n"); 
		query.append("       , A.INP_MSG11" ).append("\n"); 
		query.append("       , A.INP_MSG12" ).append("\n"); 
		query.append("       , A.INP_MSG13" ).append("\n"); 
		query.append("       , A.INP_MSG8" ).append("\n"); 
		query.append("       , A.INP_MSG9" ).append("\n"); 
		query.append("       , A.INP_MSG14" ).append("\n"); 
		query.append("       , A.INP_MSG15" ).append("\n"); 
		query.append("       , A.INP_MSG19 " ).append("\n"); 
		query.append("       , A.INP_MSG23" ).append("\n"); 
		query.append("       , A.INP_MSG16 --Remark" ).append("\n"); 
		query.append("       , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00004' AND MNR_CD_ID = A.INP_MSG4) AS INP_MSG5  --Message Name" ).append("\n"); 
		query.append("       , A.INP_MSG4  --Message Code " ).append("\n"); 
		query.append("       , A.INP_MSG3  --ERROR(E)/WARNING(W) : ERROR의 경우 다음 단계 진행 불가, WARNING의 경우 다음 단계 진행 가능" ).append("\n"); 
		query.append("       , 'NEW'    AS INP_MSG18 --trf_no" ).append("\n"); 
		query.append("       , ''    	AS INP_MSG20" ).append("\n"); 
		query.append("       , DECODE(A.INP_MSG4,'SS',1,0) AS CHECKBOX" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG11, (SELECT MNR_MEAS_UT_CD FROM MNR_RPR_TRF_HDR WHERE TRF_NO = @[std_trf_no]), A.INP_MSG8, 'INC')  AS INP_MSG24 --INCH_FM" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG11, (SELECT MNR_MEAS_UT_CD FROM MNR_RPR_TRF_HDR WHERE TRF_NO = @[std_trf_no]), A.INP_MSG8, 'CMT')  AS INP_MSG25 --CM_FM" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG11, (SELECT MNR_MEAS_UT_CD FROM MNR_RPR_TRF_HDR WHERE TRF_NO = @[std_trf_no]), A.INP_MSG9, 'INC')  AS INP_MSG26 --INCH_TO" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG11, (SELECT MNR_MEAS_UT_CD FROM MNR_RPR_TRF_HDR WHERE TRF_NO = @[std_trf_no]), A.INP_MSG9, 'CMT')  AS INP_MSG27 --CM_TO" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG11, (SELECT MNR_MEAS_UT_CD FROM MNR_RPR_TRF_HDR WHERE TRF_NO = @[std_trf_no]), A.INP_MSG13, 'INC')     AS INP_MSG21 --INCH_SIZE" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG11, (SELECT MNR_MEAS_UT_CD FROM MNR_RPR_TRF_HDR WHERE TRF_NO = @[std_trf_no]), A.INP_MSG13, 'CMT')     AS INP_MSG22 --CM_SIZE" ).append("\n"); 
		query.append("FROM     MNR_DAT_VRFY A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 

	}
}