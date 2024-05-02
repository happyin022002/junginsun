/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOGetSceActRcvIfVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.12
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.11.12 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOGetSceActRcvIfVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SceActRcvIfVO 를 추출한다.
	  * </pre>
	  */
	public CopDetailReceiveDBDAOGetSceActRcvIfVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOGetSceActRcvIfVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' as ACT_RCV_DT              ," ).append("\n"); 
		query.append("'' as ACT_RCV_NO              ," ).append("\n"); 
		query.append("'' as BKG_NO                  ," ).append("\n"); 
		query.append("'' as CNTR_NO                 ," ).append("\n"); 
		query.append("'' as ACT_DT                  ," ).append("\n"); 
		query.append("'' as ACT_STS_MAPG_CD         ," ).append("\n"); 
		query.append("'' as NOD_CD                  ," ).append("\n"); 
		query.append("'' as ACT_RCV_TP_CD           ," ).append("\n"); 
		query.append("'' as COP_RLT_FLG             ," ).append("\n"); 
		query.append("'' as ACT_UMCH_TP_CD          ," ).append("\n"); 
		query.append("'' as UMCH_CHK_DT             ," ).append("\n"); 
		query.append("'' as VSL_CD                  ," ).append("\n"); 
		query.append("'' as SKD_VOY_NO              ," ).append("\n"); 
		query.append("'' as SKD_DIR_CD              ," ).append("\n"); 
		query.append("'' as VPS_PORT_CD             ," ).append("\n"); 
		query.append("'' as CLPT_IND_SEQ            ," ).append("\n"); 
		query.append("'' as CALL_YD_IND_SEQ         ," ).append("\n"); 
		query.append("'' as EDI_MSG_TP_CD           ," ).append("\n"); 
		query.append("'' as VNDR_SEQ                ," ).append("\n"); 
		query.append("'' as ERR_MSG                 ," ).append("\n"); 
		query.append("'' as BND_VSKD_SEQ_CD         ," ).append("\n"); 
		query.append("'' as COP_EVNT_SEQ            ," ).append("\n"); 
		query.append("'' as ACT_GDT                 ," ).append("\n"); 
		query.append("'' as ACT_DAT_RCV_DT          ," ).append("\n"); 
		query.append("'' as COP_NO                  ," ).append("\n"); 
		query.append("'' as FAX_SND_RSLT_FLG        ," ).append("\n"); 
		query.append("'' as EML_SND_RSLT_FLG        ," ).append("\n"); 
		query.append("'' as EDI_SND_RSLT_FLG        ," ).append("\n"); 
		query.append("'' as ACT_CD                  ," ).append("\n"); 
		query.append("'' as RTY_RSLT_FLG            ," ).append("\n"); 
		query.append("'' as VNDR_NM                 ," ).append("\n"); 
		query.append("'' as CRE_TP_CD               ," ).append("\n"); 
		query.append("'' as PRE_BKG_NO              ," ).append("\n"); 
		query.append("'' as RAIL_DEST_N1ST_ETA_DT   ," ).append("\n"); 
		query.append("'' as VSL_DLAY_RSN_CD         ," ).append("\n"); 
		query.append("'' as VSL_DLAY_RSN_DESC       ," ).append("\n"); 
		query.append("'' as VPS_LOC_CD              ," ).append("\n"); 
		query.append("'' as CRE_USR_ID              ," ).append("\n"); 
		query.append("'' as CRE_DT                  ," ).append("\n"); 
		query.append("'' as UPD_USR_ID              ," ).append("\n"); 
		query.append("'' as UPD_DT                  ," ).append("\n"); 
		query.append("'' as CNMV_YR                 ," ).append("\n"); 
		query.append("'' as CNMV_ID_NO              ," ).append("\n"); 
		query.append("'' as CNMV_SEQ                ," ).append("\n"); 
		query.append("'' as CNMV_SPLIT_NO           ," ).append("\n"); 
		query.append("'' as CNMV_CYC_NO			  ," ).append("\n"); 
		query.append("'' as COP_DTL_SEQ" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("dual" ).append("\n"); 

	}
}