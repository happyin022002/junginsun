/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyOwnCntrStatusHistorysUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.04.15 이주현
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

public class ContainerOnOffhireDBDAOModifyOwnCntrStatusHistorysUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약번호,제작일자 수정시에만
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyOwnCntrStatusHistorysUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyOwnCntrStatusHistorysUSQL").append("\n"); 
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
		query.append("UPDATE MST_CNTR_STS_HIS A " ).append("\n"); 
		query.append("SET CNTR_STS_EVNT_DT = (SELECT DECODE(B.CO_CRE_FLG,'Y',TO_DATE(SUBSTR(@[mft_dt], 1, 10),'YYYY-MM-DD'),A.CNTR_STS_EVNT_DT)" ).append("\n"); 
		query.append("                      FROM MST_CONTAINER B" ).append("\n"); 
		query.append("                      WHERE A.CNTR_NO = B.CNTR_NO)" ).append("\n"); 
		query.append(" , OFC_CD		    = @[ofc_cd]          " ).append("\n"); 
		query.append(" , UPD_USR_ID		= @[upd_usr_id]" ).append("\n"); 
		query.append(" , UPD_DT		    = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTR_NO BETWEEN @[fm_no]||'0' AND @[to_no]||'9'" ).append("\n"); 
		query.append("AND    LENGTH(CNTR_NO) = 11" ).append("\n"); 
		query.append("AND    CNTR_STS_CD IN('LSI','OWN') " ).append("\n"); 
		query.append("AND    CNTR_STS_SEQ =(SELECT /*+ INDEX( B XAK1MST_CNTR_STS_HIS) */  B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                     FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("                     WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                     AND   B.CNTR_STS_CD IN('LSI','OWN')" ).append("\n"); 
		query.append("                     AND   ROWNUM =1)" ).append("\n"); 

	}
}