/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi214ReceiveDBDAOCreateEDI214TmpDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.14
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.14 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi214ReceiveDBDAOCreateEDI214TmpDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert tmpdata
	  * </pre>
	  */
	public Edi214ReceiveDBDAOCreateEDI214TmpDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apnt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_mnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_hr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.integration").append("\n"); 
		query.append("FileName : Edi214ReceiveDBDAOCreateEDI214TmpDataCSQL").append("\n"); 
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
		query.append("insert into edi_214_msg" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("ACT_RCV_DT" ).append("\n"); 
		query.append(",ACT_RCV_NO" ).append("\n"); 
		query.append(",TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_WO_SEQ" ).append("\n"); 
		query.append(",TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_SO_SEQ" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",SHP_STS_CD" ).append("\n"); 
		query.append(",APNT_STS_CD" ).append("\n"); 
		query.append(",RCV_DT" ).append("\n"); 
		query.append(",RCV_HR" ).append("\n"); 
		query.append(",RCV_MNT" ).append("\n"); 
		query.append(",BND_SEQ" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append(",EDI_214_MSG_SEQ.NEXTVAL" ).append("\n"); 
		query.append(",@[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_wo_seq]" ).append("\n"); 
		query.append(",@[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_so_seq]" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",@[de_cond_cd]" ).append("\n"); 
		query.append(",@[apnt_sts_cd]" ).append("\n"); 
		query.append(",@[rcv_dt]" ).append("\n"); 
		query.append(",@[rcv_hr]" ).append("\n"); 
		query.append(",@[rcv_mnt]" ).append("\n"); 
		query.append(",@[bnd_seq]" ).append("\n"); 
		query.append(",'214'" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",'214'" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}