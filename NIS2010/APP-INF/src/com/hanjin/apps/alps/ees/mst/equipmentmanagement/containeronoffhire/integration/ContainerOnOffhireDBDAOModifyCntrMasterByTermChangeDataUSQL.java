/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterByTermChangeDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.13 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterByTermChangeDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCntrMasterByTermChangeData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterByTermChangeDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_cng_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterByTermChangeDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER A" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("     (CNTR_STS_CD,LST_STS_YD_CD,LST_STS_SEQ) " ).append("\n"); 
		query.append("        =(SELECT /*+ INDEX_DESC(B XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("            B.CNTR_STS_CD, B.YD_CD, B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("        FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("        AND ROWNUM=1)	 " ).append("\n"); 
		query.append("     ,(LSTM_CD,AGMT_CTY_CD,AGMT_SEQ,VNDR_SEQ,ONH_FREE_DYS,MIN_ONH_DYS)" ).append("\n"); 
		query.append("        =(SELECT /*+ INDEX_DESC(B XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("              (SELECT C.LSTM_CD" ).append("\n"); 
		query.append("              FROM LSE_AGREEMENT C" ).append("\n"); 
		query.append("              WHERE B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("              AND   B.AGMT_SEQ = C.AGMT_SEQ), " ).append("\n"); 
		query.append("              B.AGMT_CTY_CD,B.AGMT_SEQ," ).append("\n"); 
		query.append("             (SELECT C.VNDR_SEQ" ).append("\n"); 
		query.append("              FROM LSE_AGREEMENT C" ).append("\n"); 
		query.append("              WHERE B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("              AND   B.AGMT_SEQ = C.AGMT_SEQ)," ).append("\n"); 
		query.append("              B.RNTL_CHG_FREE_DYS,B.CNTR_MIN_ONH_DYS" ).append("\n"); 
		query.append("        FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("        AND   B.CNTR_STS_CD IN('LSI','OWN','DII')" ).append("\n"); 
		query.append("        AND ROWNUM=1)" ).append("\n"); 
		query.append("    ,(ONH_CNTR_STS_CD,ONH_DT,ONH_YD_CD,ONH_STS_SEQ) " ).append("\n"); 
		query.append("        = (SELECT B.CNTR_STS_CD,B.CNTR_STS_EVNT_DT,B.YD_CD,B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("           FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("           WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND   B.CNTR_STS_SEQ = MST_ONH_STS_SEQ_FNC(A.CNTR_NO))        " ).append("\n"); 
		query.append("    ,TERM_CNG_SEQ	     = @[term_cng_seq]" ).append("\n"); 
		query.append("    ,OWNR_CO_CD          = 'H'" ).append("\n"); 
		query.append("    ,CNTR_USE_CO_CD      = 'H'" ).append("\n"); 
		query.append("    ,UPD_USR_ID          = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,UPD_DT              = SYSDATE" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    CNTR_NO             = @[cntr_no]" ).append("\n"); 

	}
}