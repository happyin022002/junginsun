/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterByLostFoundDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterByLostFoundDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMasterByLostFoundData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterByLostFoundDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_onh_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterByLostFoundDataUSQL").append("\n"); 
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
		query.append("SET  A.CNMV_DT       = TO_DATE(@[h_cnmv_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	,(A.LST_STS_SEQ, A.CNTR_STS_CD,A.LST_STS_YD_CD) = (" ).append("\n"); 
		query.append("	    SELECT /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.CNTR_STS_SEQ, A.CNTR_STS_CD, A.YD_CD" ).append("\n"); 
		query.append("	    FROM   MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("	    WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	    AND ROWNUM =1" ).append("\n"); 
		query.append("		)	" ).append("\n"); 
		query.append("    ,A.CRNT_YD_CD    = @[h_onh_yd_cd]" ).append("\n"); 
		query.append("    ,A.LOC_CD = SUBSTR(@[h_onh_yd_cd],1,5)" ).append("\n"); 
		query.append("	,(A.SCC_CD, A.LCC_CD, A.ECC_CD, A.RCC_CD) = (SELECT B.SCC_CD, B.LCC_CD, B.ECC_CD, B.RCC_CD FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B WHERE A.LOC_CD = SUBSTR(@[h_onh_yd_cd], 1, 5) AND A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append("    ,A.CNMV_STS_CD   = DECODE(@[h_cntr_sts_cd],'LST','XX','MT')" ).append("\n"); 
		query.append("    ,A.ACIAC_DIV_CD  = DECODE(@[h_cntr_sts_cd],'LST','I','A')" ).append("\n"); 
		query.append("    ,A.CNTR_RMK     = @[cntr_rmk]" ).append("\n"); 
		query.append("    ,A.UPD_USR_ID	= @[upd_usr_id]" ).append("\n"); 
		query.append("    ,A.UPD_DT		= sysdate" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}