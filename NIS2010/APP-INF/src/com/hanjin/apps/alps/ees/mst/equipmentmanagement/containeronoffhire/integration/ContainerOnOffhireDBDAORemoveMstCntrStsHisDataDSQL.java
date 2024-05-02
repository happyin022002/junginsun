/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerOnOffhireDBDAORemoveMstCntrStsHisDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.27
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.04.27 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAORemoveMstCntrStsHisDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveMstCntrStsHisData
	  * 2011.04.27 남궁진호 [CHM-201110291-01] MNR SOLD Cancel 기능 추가에따른  기능보완
	  * Container Status Delete기능 통합쿼리
	  * </pre>
	  */
	public ContainerOnOffhireDBDAORemoveMstCntrStsHisDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAORemoveMstCntrStsHisDataDSQL").append("\n"); 
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
		query.append("DELETE MST_CNTR_STS_HIS" ).append("\n"); 
		query.append("WHERE   (CNTR_NO, CNTR_STS_SEQ) IN " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CNTR_NO, CNTR_STS_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  /*+ INDEX_DESC (MST_CNTR_STS_HIS XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                CNTR_NO, CNTR_STS_SEQ, CNTR_STS_CD" ).append("\n"); 
		query.append("        FROM    MST_CNTR_STS_HIS" ).append("\n"); 
		query.append("        WHERE   CNTR_NO = @[cntr_no]    --(입력 파라메터)" ).append("\n"); 
		query.append("        AND     ROWNUM  = 1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   CNTR_STS_CD = @[cntr_sts_cd]                 --(입력 파라메터)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}