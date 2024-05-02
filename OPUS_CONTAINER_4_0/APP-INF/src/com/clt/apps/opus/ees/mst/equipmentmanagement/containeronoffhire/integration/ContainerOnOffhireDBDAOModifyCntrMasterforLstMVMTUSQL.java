/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterforLstMVMTUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.10.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterforLstMVMTUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Laste Movement Information Update
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterforLstMVMTUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterforLstMVMTUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER MC" ).append("\n"); 
		query.append("      SET  " ).append("\n"); 
		query.append("         (  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("         , CNMV_YR" ).append("\n"); 
		query.append("         , CNMV_ID_NO" ).append("\n"); 
		query.append("         , CNMV_SEQ " ).append("\n"); 
		query.append("         , CNMV_SPLIT_NO" ).append("\n"); 
		query.append("         , CNMV_CYC_NO" ).append("\n"); 
		query.append("         , CNMV_DT" ).append("\n"); 
		query.append("         , CNMV_GDT" ).append("\n"); 
		query.append("         , PRE_STS_FLG" ).append("\n"); 
		query.append("         , FULL_FLG" ).append("\n"); 
		query.append("         , CRNT_YD_CD" ).append("\n"); 
		query.append("         , CNMV_STS_CD" ).append("\n"); 
		query.append("         , IMDT_EXT_FLG" ).append("\n"); 
		query.append("         , LOC_CD" ).append("\n"); 
		query.append("         , SCC_CD" ).append("\n"); 
		query.append("         , LCC_CD" ).append("\n"); 
		query.append("         , ECC_CD" ).append("\n"); 
		query.append("         , RCC_CD" ).append("\n"); 
		query.append("         , CO_CRE_FLG" ).append("\n"); 
		query.append("         , ACIAC_DIV_CD)" ).append("\n"); 
		query.append("          = ( SELECT /*+ INDEX_DESC(CM XAK2CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                      CM.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                     , CM.CNMV_YR" ).append("\n"); 
		query.append("                     , CM.CNMV_ID_NO" ).append("\n"); 
		query.append("                     , CM.CNMV_SEQ     " ).append("\n"); 
		query.append("                     , CM.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                     , CM.CNMV_CYC_NO" ).append("\n"); 
		query.append("                     , CM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                     , GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (CM.ORG_YD_CD, 0, 5 ), CM.CNMV_EVNT_DT, 'GMT' ) AS CNMV_GDT" ).append("\n"); 
		query.append("                     , 'N' AS PRE_STS_FLG" ).append("\n"); 
		query.append("                     , CM.FCNTR_FLG" ).append("\n"); 
		query.append("                     , CM.ORG_YD_CD" ).append("\n"); 
		query.append("                     , CM.MVMT_STS_CD" ).append("\n"); 
		query.append("                     , CM.IMDT_EXT_FLG" ).append("\n"); 
		query.append("                     , SUBSTR(CM.ORG_YD_CD, 1, 5) AS LOC_CD" ).append("\n"); 
		query.append("                     , MST_LOC_FNC(SUBSTR(CM.ORG_YD_CD, 1, 5),'SCC')    AS SCC_CD" ).append("\n"); 
		query.append("                     , MST_LOC_FNC(SUBSTR(CM.ORG_YD_CD, 1, 5),'LCC')    AS LCC_CD" ).append("\n"); 
		query.append("                     , MST_LOC_FNC(SUBSTR(CM.ORG_YD_CD, 1, 5),'ECC')    AS ECC_CD" ).append("\n"); 
		query.append("                     , MST_LOC_FNC(SUBSTR(CM.ORG_YD_CD, 1, 5),'RCC')    AS RCC_CD" ).append("\n"); 
		query.append("                     , 'N' CO_CRE_FLG" ).append("\n"); 
		query.append("                     , DECODE(CM.MVMT_STS_CD, 'XX', 'I', 'A')" ).append("\n"); 
		query.append("               FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("              WHERE MC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("                AND ROWNUM    = 1)" ).append("\n"); 
		query.append("         , UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("         , UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE MC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("               WHERE MC.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("                 AND ROWNUM     = 1)" ).append("\n"); 
		query.append("AND   ROWNUM     = 1" ).append("\n"); 

	}
}