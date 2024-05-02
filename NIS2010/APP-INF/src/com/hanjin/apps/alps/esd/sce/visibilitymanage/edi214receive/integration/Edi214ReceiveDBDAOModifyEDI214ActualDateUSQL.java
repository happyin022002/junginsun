/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi214ReceiveDBDAOModifyEDI214ActualDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.11.25 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi214ReceiveDBDAOModifyEDI214ActualDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update edi214
	  * </pre>
	  */
	public Edi214ReceiveDBDAOModifyEDI214ActualDateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214Receive.integration ").append("\n"); 
		query.append("FileName : Edi214ReceiveDBDAOModifyEDI214ActualDateUSQL").append("\n"); 
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
		query.append("update SCE_COP_DTL" ).append("\n"); 
		query.append("SET 	ACT_DT 			=  TO_DATE(@[rcv_dt]||@[rcv_hr]||@[rcv_mnt]||'00','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",ACT_RCV_TP_CD 	= '0'" ).append("\n"); 
		query.append(",UPD_USR_ID 	= 'EDI_214_PoD'" ).append("\n"); 
		query.append(",UPD_DT 		=  sysdate" ).append("\n"); 
		query.append(",ACT_DAT_RCV_DT =  GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, SUBSTR(NOD_CD,1,5))" ).append("\n"); 
		query.append("WHERE COP_NO = (select cop_no from trs_trsp_svc_ord where TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] and TRSP_SO_SEQ = @[trsp_so_seq] )" ).append("\n"); 
		query.append("AND COP_DTL_SEQ = TO_NUMBER(SUBSTR(@[cop_seq],1,4))" ).append("\n"); 

	}
}