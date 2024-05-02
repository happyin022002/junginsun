/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ConstraintMasterDBDAOBookingStowageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.29 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOBookingStowageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  Stowage List 
	  * </pre>
	  */
	public ConstraintMasterDBDAOBookingStowageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOBookingStowageRSQL").append("\n"); 
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
		query.append("SELECT   INTG_CD_ID   " ).append("\n"); 
		query.append(",        INTG_CD_VAL_CTNT as VAL" ).append("\n"); 
		query.append(",        INTG_CD_VAL_DESC as NAME" ).append("\n"); 
		query.append(",        INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(",        INTG_CD_VAL_CTNT || '	' || INTG_CD_VAL_DESC AS MULTIDESC" ).append("\n"); 
		query.append(",        decode(BAMD.BKG_ALOC_SEQ,null,'N','Y') as chk " ).append("\n"); 
		query.append("FROM     COM_INTG_CD_DTL COM, (SELECT BAMD.BKG_ALOC_SEQ , BAMD.SB_LOC_CD FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE  BAMD.BKG_ALOC_SEQ = @[bkg_aloc_seq] AND BAMD.SB_LOC_DIV_CD = 'STW' )  BAMD" ).append("\n"); 
		query.append("WHERE    INTG_CD_ID = 'CD02146'" ).append("\n"); 
		query.append("AND      (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = BAMD.SB_LOC_CD(+)" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}