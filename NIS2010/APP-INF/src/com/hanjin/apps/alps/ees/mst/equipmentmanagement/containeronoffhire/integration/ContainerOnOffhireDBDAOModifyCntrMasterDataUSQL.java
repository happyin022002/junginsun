/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.22
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.07.22 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMasterData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterDataUSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mtrl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_dgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterDataUSQL").append("\n"); 
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
		query.append("SET" ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD  = @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("A.CNTR_MTRL_CD  = @[cntr_mtrl_cd]," ).append("\n"); 
		query.append("A.MFTR_VNDR_SEQ = @[vndr_abbr_nm]," ).append("\n"); 
		query.append("A.MFT_DT        = TO_DATE(@[mft_dt], 'YYYY-MM-DD')," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#if (${lstm_cd} == 'LT')" ).append("\n"); 
		query.append(",   RF_TP_CD  = DECODE(SUBSTR(@[cntr_tpsz_cd],1,1),'R',@[rf_tp_cd],'')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.CNTR_NO = (SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append("FROM MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("##${cntr_no}" ).append("\n"); 
		query.append("#if ($cntr_no.length() == 10)" ).append("\n"); 
		query.append("#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("AND   CNTR_NO LIKE @[cntr_no] || MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(@[cntr_no], 1) ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_dgt} != '')" ).append("\n"); 
		query.append("AND   CNTR_NO LIKE @[cntr_no] || @[chk_dgt] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("##${cntr_no}" ).append("\n"); 
		query.append("#if ($cntr_no.length() != 10)" ).append("\n"); 
		query.append("AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CNMV_DT = (" ).append("\n"); 
		query.append("SELECT MAX(CNMV_DT)" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("##${cntr_no}" ).append("\n"); 
		query.append("#if ($cntr_no.length() == 10)" ).append("\n"); 
		query.append("#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("AND   CNTR_NO LIKE @[cntr_no] || MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(@[cntr_no], 1) ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_dgt} != '')" ).append("\n"); 
		query.append("AND   CNTR_NO LIKE @[cntr_no] || @[chk_dgt] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("##${cntr_no}" ).append("\n"); 
		query.append("#if ($cntr_no.length() != 10)" ).append("\n"); 
		query.append("AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}